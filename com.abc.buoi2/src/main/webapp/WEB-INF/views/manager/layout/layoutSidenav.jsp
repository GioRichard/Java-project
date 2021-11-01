<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div id="layoutSidenav_nav">
	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		<div class="sb-sidenav-menu">
			<div class="nav">
				<a class="nav-link" href="${base }/manager/ad_index">
					Dashboard
				</a>
				 <a class="nav-link collapsed" href="${base }/manager/categories"> Categories </a> 
					
					<a
					class="nav-link collapsed" href="${base }/manager/ad_product"> Products </a>
					
					 <a
					class="nav-link collapsed" href="${base }/manager/ad_index" data-bs-toggle="collapse"
					data-bs-target="#collapsePages" aria-expanded="false"
					aria-controls="collapsePages"> Contact </a> <a
					class="nav-link collapsed" href="#" data-bs-toggle="collapse"
					data-bs-target="#collapsePages" aria-expanded="false"
					aria-controls="collapsePages"> Roles </a> <a
					class="nav-link collapsed" href="${base }/user/index" data-bs-toggle="collapse"
					data-bs-target="#collapsePages" aria-expanded="false"
					aria-controls="collapsePages"> Users </a>
			</div>
		</div>
		<div class="sb-sidenav-footer">
			<div class="small">End Footer</div>
			
		</div>
	</nav>
</div>
