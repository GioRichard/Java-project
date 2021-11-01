package com.abc.buoi2.services;

import java.io.File;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.abc.buoi2.dto.Constants;
import com.abc.buoi2.dto.ProductSearch;
import com.abc.buoi2.entities.Product;
import com.abc.buoi2.entities.ProductsImages;


@Service
public class ProductService extends BaseService<Product> implements Constants{

	@Override
	protected Class<Product> clazz() {	
		return Product.class;
	}
	
	//tất cả các soevices cần hàm search
	public List<Product>search(ProductSearch searchModel){
		String sql = "SELECT * FROM tbl_products p WHERE 1=1";
		
//		//tim kiem san pham theo categoryId
//		if(searchModel.getCategoryId() > 0) {
//			sql +=" and p.category_id ="+searchModel.getCategoryId();	
//		}
//		
//		//tim kiem san pham theo categorySeo
//		if(!StringUtils.isEmpty(searchModel.getCategorySeo())) {
//			sql +=" and p.category_id in (select id from tbl_category"
//					+ " c where c.seo ='"+ searchModel.getCategorySeo() + "')";
//		}
		
		//tim kiem san pham theo seachText
		if(!StringUtils.isEmpty(searchModel.getKeyword())) {
			sql +=" and (p.title like'%" + searchModel.getKeyword() + "%'" + " or p.detail_description like '%" + 
					searchModel.getKeyword() + "%'" + " or p.short_description like '%" 
					+ searchModel.getKeyword() + "%')";    
		}
		
		//chi lay san pham chua xoa
		sql += " and p.status=1";
		
		return executeNativeSql(sql, searchModel.getPage());
	}
	
	private boolean isEmptyUploadFile(MultipartFile[] images) {
		if(images==null || images.length<=0)
			return true;
		if(images.length==1 && images[0].getOriginalFilename().isEmpty())
			return true;
		
		return false;
	}
	
	private boolean isEmptyUploadFile(MultipartFile image) {
		return image==null || image.getOriginalFilename().isEmpty();
	}
	
	
	//vua tao moi vua chinh sua san pham
	@Transactional
	public Product save(Product product, MultipartFile productAvatar,MultipartFile[] productPictures) throws Exception {
		
		//co day avatar len ko?
		if(!isEmptyUploadFile(productAvatar)) {
			String pathToFile = UPLOAD_FOLDER_ROOT + "product/avatar/"
					+ productAvatar.getOriginalFilename();
			productAvatar.transferTo(new File(pathToFile));
			product.setAvatar("product/avatar/" + productAvatar.getOriginalFilename());
		}
		
		//co day pictures??
		if(!isEmptyUploadFile(productPictures)) {
			for(MultipartFile pic:productPictures) {
				pic.transferTo(new File(UPLOAD_FOLDER_ROOT + "product/pictures/" + pic.getOriginalFilename()));
			
				ProductsImages pi = new ProductsImages();
				pi.setPath("product/pictures/" + pic.getOriginalFilename());
				pi.setTitle(pic.getOriginalFilename());
				
				product.addProductsImages(pi);
			}
		}
		
		//luu vao databese
		return super.saveOrupdate(product);
	}
}
