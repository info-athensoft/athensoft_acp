<div class="page-sidebar-wrapper">
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
				<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
				<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
				<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
				<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
				<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
				<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
					<!-- Overview Dashboard -->
					<li class="start active ">
						<a href="/acp/index">
						<i class="icon-home"></i>
						<span class="title">Dashboard</span>
						<span id="menu-dashborad" class="selected"></span>
						</a>
					</li>
					
					
					<!-- E-Commerce System -->
					<li>
						<a href="javascript:;">
						<i class="icon-basket"></i>
						<span class="title">E-Commerce</span>
						<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<!-- E-Commerce Dashboard -->
							<li>
								<a href="#">
								<i class="icon-bar-chart"></i>
								Dashboard</a>
							</li>
							
							
							<li>
								<a href="#">
								<i class="icon-basket-loaded"></i>
								Order<span class="arrow"></span></a>
								<ul class="sub-menu">
									<li>
										<a href="/acp/orders">
										<i class="icon-eye"></i>
										Order List</a>
									</li>
									<li>
										<a href="/acp/ecomm/ordersview">
										<i class="icon-eye"></i>
										Orders View</a>
									</li>
								</ul>
							</li>
							
							
							<li>
								<a href="#">
								<i class="icon-tag"></i>
								Sale<span class="arrow"></span></a>
								<ul class="sub-menu">
									<li>
										<a href="#">
										<i class="icon-tag"></i>
										Pricing</a>
									</li>
								</ul>
							</li>
							
							
							<li>
								<a href="#">
								<i class="icon-home"></i>
								Inventory<span class="arrow"></span></a>
								<ul class="sub-menu">
									<li>
										<a href="#">
										<i class="icon-pencil"></i>
										Inventory</a>
									</li>
								</ul>
							</li>
							
							<!--
							<li>
								<a href="/acp/orders">
								<i class="icon-doc"></i>
								Orders</a>
							</li>
							<li>
								<a href="/acp/ecomm/ordersview">
								<i class="icon-doc"></i>
								Orders View</a>
							</li>
							 
							<li>
								<a href="ecommerce_index.html">
								<i class="icon-doc"></i>
								Distributor profile</a>
							</li>
							<li>
								<a href="/admin/bizprofile">
								<i class="icon-users"></i>
								View my advertisers</a>
							</li>
							<li>
								<a href="page_portfolio.html">
								<i class="icon-wallet"></i>
								Cashing credits</a>
							</li>
							 -->
						</ul>
					</li>
					
					<!-- Item system -->
					<li>
						<a href="javascript:;">
						<i class="icon-social-dropbox"></i>
						<span class="title">Item</span>
						<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li>
								<a href="/acp/item/dashboard">
								<i class="icon-bar-chart"></i>
								Dashboard</a>
							</li>
							<li>
								<a href="#">
								<i class="icon-drawer"></i>
								Product Category</a>
								<ul class="sub-menu">
									<li>
										<a href="/acp/item/testcategory">
										<i class="icon-paper-plane"></i>
										Category Test</a>
									</li>
									<li>
										<a href="/acp/item/samplecategory">
										<i class="icon-paper-plane"></i>
										Category Sample</a>
									</li>
									<li>
										<a href="/acp/item/categoryList">
										<i class="icon-eye"></i>
										Category List</a>
									</li>
									<li>
										<a href="/acp/item/categoryListTree">
										<i class="icon-eye"></i>
										Category List Tree</a>
									</li>
									<li>
										<a href="/acp/item/categoryEdit">
										<i class="icon-pencil"></i>
										Category Edit</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="#">
								<i class="icon-social-dropbox"></i>
								Product</a>
								<ul class="sub-menu">
									<li>
										<a href="/acp/item/productList">
										<i class="icon-eye"></i>
										Product List</a>
									</li>
									<li>
										<a href="/acp/item/productEdit">
										<i class="icon-pencil"></i>
										Product Edit</a>
									</li>
									<li>
										<a href="/acp/item/productEdit">
										<i class="icon-grid"></i>
										Product Mix</a>
									</li>
								</ul>
							</li>
							
							<li>
								<a href="#">
								<i class="icon-drawer"></i>
								Service Category</a>
								<ul class="sub-menu">
									<li>
										<a href="/acp/item/testcategory">
										<i class="icon-paper-plane"></i>
										Category Test</a>
									</li>
									<li>
										<a href="/acp/item/samplecategory">
										<i class="icon-paper-plane"></i>
										Category Sample</a>
									</li>
									<li>
										<a href="/acp/item/categoryList">
										<i class="icon-eye"></i>
										Category List</a>
									</li>
									<li>
										<a href="/acp/item/categoryListTree">
										<i class="icon-eye"></i>
										Category List Tree</a>
									</li>
									<li>
										<a href="/acp/item/categoryEdit">
										<i class="icon-pencil"></i>
										Category Edit</a>
									</li>
								</ul>
							</li>
							
							
							<li>
								<a href="#">
								<i class="icon-briefcase"></i>
								Service</a>
								<ul class="sub-menu">
									<li>
										<a href="/acp/item/serviceList">
										<i class="icon-paper-plane"></i>
										Service List</a>
									</li>
									<li>
										<a href="/acp/item/serviceEdit">
										<i class="icon-pencil"></i>
										Service Edit</a>
									</li>
								</ul>
							</li>
							
						</ul>
					</li>
					<!-- end product system -->
					
					<!-- customer, CRM system -->
					<li>
						<a href="#">
						<i class="icon-users"></i>
						<span class="title">Customer</span>
						<span id="menu-dashborad"></span>
						</a>
					</li>
					
					<!-- supplier system -->
					<li>
						<a href="#">
						<i class="icon-users"></i>
						<span class="title">Supplier</span>
						<span id="menu-dashborad"></span>
						</a>
					</li>
					
					
					<!-- event system -->
					<li class="start active ">
						<a href="javascript:;">
						<i class="icon-calendar"></i>
						<span class="title">Event</span>
						<span class="arrow "></span>
						<span id="menu-myevents"></span>
						</a>
						<ul class="sub-menu">
							<li>
								<a href="/acp/event/dashboard">
								<i class="icon-bar-chart"></i>
								Dashboard</a>
								
							</li>
							<li>
								<a href="#">
								<i class="icon-bell"></i>
								News<span class="arrow"></span></a>
								<ul class="sub-menu">
								<li>
									<a href="/acp/events/eventsNewsList">
									<i class="icon-eye"></i>
									News List</a>
								</li>
								<li>
									<a href="/acp/events/eventsNewsList">
									<i class="icon-pencil"></i>
									News Edit</a>
								</li>
								<li>
									<a href="/acp/events/eventsNewsCreate">
									<i class="icon-pencil"></i>
									News Create</a>
								</li>
								<li>
									<a href="/acp/events/eventsNewsDelete">
									<i class="icon-key"></i>
									News Remove - Admin</a>
								</li>
								</ul>
							</li>
							<li>
								<a href="#">
								<i class="icon-bell"></i>
								Activity<span class="arrow"></span></a>
							</li>
						</ul>
					</li>
					<!-- end event system -->
					
					
					<!-- system settings -->
					<li>
						<a href="#">
						<i class="icon-settings"></i>
						<span class="title">System</span>
						<span id="menu-dashborad"></span>
						</a>
					</li>
					
					
					<!-- 
					<li>
						<a href="javascript:;">
						<i class="icon-user"></i>
						<span class="title">Advertiser</span>
						<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li>
								<a href="ecommerce_index.html">
								<i class="icon-home"></i>
								Dashboard</a>
							</li>
							<li>
								<a href="page_portfolio.html">
								<i class="icon-pencil"></i>
								Edit Business Profile</a>
							</li>
							<li>
								<a href="/admin/bizprofile">
								<i class="icon-paper-plane"></i>
								Post Ad. Page</a>
							</li>
							<li>
								<a href="ecommerce_orders.html">
								<i class="icon-basket"></i>
								Order a service</a>
							</li>
						</ul>
					</li>
					 -->
					
					<!-- 
					<li>
						<a href="javascript:;">
						<i class="icon-star"></i>
						<span class="title">My Credits</span>
						<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li>
								<a href="ecommerce_index.html">
								<i class="icon-home"></i>
								Dashboard</a>
							</li>
							<li>
								<a href="ecommerce_orders.html">
								<i class="icon-basket"></i>
								Orders</a>
							</li>
							<li>
								<a href="ecommerce_orders_view.html">
								<i class="icon-tag"></i>
								Order View</a>
							</li>
							<li>
								<a href="ecommerce_products.html">
								<i class="icon-handbag"></i>
								Products</a>
							</li>
							<li>
								<a href="ecommerce_products_edit.html">
								<i class="icon-pencil"></i>
								Product Edit</a>
							</li>
						</ul>
					</li>
					 -->
					
					<!-- 
					<li>
						<a href="javascript:;">
						<i class="icon-basket"></i>
						<span class="title">My Purchase</span>
						<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li>
								<a href="ecommerce_index.html">
								<i class="icon-home"></i>
								Dashboard</a>
							</li>
							<li>
								<a href="ecommerce_orders.html">
								<i class="icon-basket"></i>
								Order a service</a>
							</li>
							<li>
								<a href="ecommerce_orders_view.html">
								<i class="icon-docs"></i>
								History Orders</a>
							</li>
							<li>
								<a href="ecommerce_products.html">
								<i class="icon-handbag"></i>
								View Adogo Services</a>
							</li>
							
						</ul>
					</li>
					 -->
					
					<!-- 
					<li>
						<a href="javascript:;">
						<i class="icon-badge"></i>
						<span class="title">My Certificates</span>
						<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li>
								<a href="/admin/bizprofile">
								<i class="icon-info"></i>
								Post Business Profile</a>
							</li>
							<li>
								<a href="page_portfolio.html">
								<i class="icon-feed"></i>
								Edit Ad. Page</a>
							</li>
						</ul>
					</li>
					-->
					
					<!-- 
					<li>
						<a href="javascript:;">
						<i class="icon-folder"></i>
						<span class="title">Multi Level Menu</span>
						<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li>
								<a href="javascript:;">
								<i class="icon-settings"></i> Item 1 <span class="arrow"></span>
								</a>
								<ul class="sub-menu">
									<li>
										<a href="javascript:;">
										<i class="icon-user"></i>
										Sample Link 1 <span class="arrow"></span>
										</a>
										<ul class="sub-menu">
											<li>
												<a href="#"><i class="icon-power"></i> Sample Link 1</a>
											</li>
											<li>
												<a href="#"><i class="icon-paper-plane"></i> Sample Link 1</a>
											</li>
											<li>
												<a href="#"><i class="icon-star"></i> Sample Link 1</a>
											</li>
										</ul>
									</li>
									<li>
										<a href="#"><i class="icon-camera"></i> Sample Link 1</a>
									</li>
									<li>
										<a href="#"><i class="icon-link"></i> Sample Link 2</a>
									</li>
									<li>
										<a href="#"><i class="icon-pointer"></i> Sample Link 3</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="javascript:;">
								<i class="icon-globe"></i> Item 2 <span class="arrow"></span>
								</a>
								<ul class="sub-menu">
									<li>
										<a href="#"><i class="icon-tag"></i> Sample Link 1</a>
									</li>
									<li>
										<a href="#"><i class="icon-pencil"></i> Sample Link 1</a>
									</li>
									<li>
										<a href="#"><i class="icon-graph"></i> Sample Link 1</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="#">
								<i class="icon-bar-chart"></i>
								Item 3 </a>
							</li>
						</ul>
					</li>
					 -->
									
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>