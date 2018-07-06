<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
    
    <head>
        <!-- Meta -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta name="description" content="Here you can find wide rage of models of CNC milling machines for the best prices.">
        <meta name="author" content="">
        <meta name="keywords" content="Deckel mano, mori seiki, haas, cnc machines for sale, horizontal milling machine for sale, buy cnc machine, vertical milling machine for sale, cnc machine price, cnc machine cost, buy cnc machine, cnc machining center for sale ">
        <meta name="robots" content="all">

        <title><spring:message code="linesall.title" text="Automated lines" /></title>

        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href="../resources/assets/css/bootstrap.min.css">
        
        <!-- Customizable CSS -->
        <link rel="stylesheet" href="../resources/assets/css/main.css">
        <link rel="stylesheet" href="../resources/assets/css/green.css">
        <link rel="stylesheet" href="../resources/assets/css/owl.carousel.css">
        <link rel="stylesheet" href="../resources/assets/css/owl.transitions.css">
        <link rel="stylesheet" href="../resources/assets/css/animate.min.css">

        <!-- Demo Purpose Only. Should be removed in production -->
        <link rel="stylesheet" href="../resources/assets/css/config.css">

        <link href="../resources/assets/css/green.css" rel="alternate stylesheet" title="Green color">
        <link href="../resources/assets/css/blue.css" rel="alternate stylesheet" title="Blue color">
        <link href="../resources/assets/css/red.css" rel="alternate stylesheet" title="Red color">
        <link href="../resources/assets/css/orange.css" rel="alternate stylesheet" title="Orange color">
        <link href="../resources/assets/css/navy.css" rel="alternate stylesheet" title="Navy color">
        <link href="../resources/assets/css/dark-green.css" rel="alternate stylesheet" title="Darkgreen color">
        <!-- Demo Purpose Only. Should be removed in production : END -->

        <!-- Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>
        
        <!-- Icons/Glyphs -->
        <link rel="stylesheet" href="../resources/assets/css/font-awesome.min.css">
        
        <!-- Favicon -->
        <link rel="shortcut icon" href="../resources/assets/images/favicon.ico"> 

        <!-- HTML5 elements and media queries Support for IE8 : HTML5 shim and Respond.js -->
        <!--[if lt IE 9]>
            <script src="assets/js/html5shiv.js"></script>
            <script src="assets/js/respond.min.js"></script>
        <![endif]-->
    </head>
    
<body>
    
    <div class="wrapper">
        
<!-- ============================================================= TOP NAVIGATION ============================================================= -->
 <%@include file="/WEB-INF/pages/in/nav.jsp" %>  
<!-- ============================================================= TOP NAVIGATION : END ============================================================= -->       
<!-- ============================================================= HEADER ============================================================= -->
<%@include file="/WEB-INF/pages/in/header.jsp" %>
<!-- ============================================================= HEADER : END ============================================================= --><div class="animate-dropdown"><!-- ========================================= BREADCRUMB ========================================= -->

    
    <div id="top-mega-nav">
    <div class="container">
        <nav>
            <ul class="inline">
                <!--<li class="dropdown le-dropdown">-->
                  <%@include file="/WEB-INF/pages/in/dropdown_le_dropdown.jsp" %>
                <!--</li>-->

                <li class="breadcrumb-nav-holder"> 
                    <ul>

                        <!--<li class="breadcrumb-item">-->
                          <%@include file="/WEB-INF/pages/in/breadcrumb_item.jsp" %>
                        <!--</li>--> 
  
                       <li class="breadcrumb-item current">
                            <a href="#"><spring:message code="linesall.title" text="Automated Lines" /></a>
                        </li> 
                    </ul>
                </li><!-- /.breadcrumb-nav-holder -->

            </ul><!-- /.inline -->
        </nav>

    </div><!-- /.container -->
</div><!-- /#top-mega-nav -->
<!-- ========================================= BREADCRUMB : END ========================================= --></div>     <section id="category-grid">
    <div class="container">
    <c:set var="localeCode" value="${pageContext.response.locale}" />    
        <!-- ========================================= SIDEBAR ========================================= -->
        <div class="col-xs-12 col-sm-3 no-margin sidebar narrow">


            <!-- ========================================= PRODUCT FILTER ========================================= -->
            
            <div class="widget">
    <h1><spring:message code="linesall.productfilters" text="Product Filters" /></h1>
    <div class="body bordered"> <!-- body -->
        
        <form:form id="filterForm" action="/lines" method="GET">          
          
            <!--Workpiece -->      
                <c:if test="${!empty listLineWorkpiece}" >               
                <div class="category-filter">
                            <h2> <spring:message code="linesall.workpiece" text="Workpiece" /> </h2>
                             <!--<hr>--> 
                             <div id="item-count" class="le-select">
                                 <select name="workpiece">  
                                     <option value='' ><spring:message code="linesall.workpiece_not_selected" text="Workpiece not selected" /></option> 
                                          <!--<option disabled>Select axes</option>-->  
                                          <c:forEach items="${listLineWorkpiece}" var="aa">
                                              <c:if test="${localeCode == 'en'}">
                                              <option value="${aa.workpieceEn}"
                                                         <c:if test="${aa.workpieceEn == workpieceEn}">selected</c:if>                 
                                                  > ${aa.workpieceEn}(${aa.num}) </option>  
                                              </c:if>
                                              <c:if test="${localeCode == 'russia'}">
                                              <option value="${aa.workpieceEn}"
                                                         <c:if test="${aa.workpieceEn == workpieceEn}">selected</c:if>                 
                                                  > ${aa.workpieceRu}(${aa.num}) </option>  
                                              </c:if>                           
                                          </c:forEach>
                                 </select>
                            </div>
                        </div>         
                </c:if>
         
        <br/>
            <button class="le-button small">
              <spring:message code="linesall.filter" text="Filter Lines" /> 
            </button>   
            
         </form:form>  
 

    </div><!-- /.body -->
</div><!-- /.widget -->
<!-- ========================================= PRODUCT FILTER : END ========================================= -->
            

<!-- ========================================= FEATURED PRODUCTS ========================================= -->
                    <!--We deleted it-->
<!-- ========================================= FEATURED PRODUCTS : END ========================================= -->

        </div>
        <!-- ========================================= SIDEBAR : END ========================================= -->

        <!-- ========================================= CONTENT ========================================= -->

        <div class="col-xs-12 col-sm-9 no-margin wide sidebar">


            
  <section id="gaming">
    <div class="grid-list-products">       
        <div class="control-bar">
            <div class="grid-list-buttons">
                <ul>
                    <li class="grid-list-button-item active"><a data-toggle="tab" href="#grid-view"><i class="fa fa-th-large"></i><spring:message code="linesall.grid" text="Grid" /></a></li>
                    <li class="grid-list-button-item "><a data-toggle="tab" href="#list-view"><i class="fa fa-th-list"></i><spring:message code="linesall.list" text="List" /></a></li>
                </ul>
            </div>
        </div>
                                
        <div class="tab-content">
            <div id="grid-view" class="products-grid fade tab-pane in active">
                
                <div class="product-grid-holder">
                    <div class="row no-margin">
                        
                        
            <c:forEach items="${listAutomatedLine}" var="line"> 
                        <div class="col-xs-12 col-sm-4 no-margin product-item-holder hover">
                            <div class="product-item">
                            
                                <div class="image">
                                    <!--<img alt="" src="../resources/assets/images/blank.gif" data-echo="../resources/assets/images/products/${vmc.photo1}" width="246" height="186" />-->
                                    <a href="/line-${line.url}">
                                        <c:forEach var="photo" items="${line.photos}" begin="0" end="0">
                                            <img alt="${line.modelEn}" src="../resources/assets/images/blank.gif" 
                                            data-echo="../resources/assets/images/products/${photo.name}" width="246" height="186" />
                                        </c:forEach>
                                    </a>
                                </div>
                                <div class="body">
                                    <!--<div class="label-discount green">-10 % sale</div>-->
                                    <div class="title">
                                        <a href="/line-${line.url}"> ${line.modelEn}  </a>
                                    </div>
                                    <div class="brand"><spring:message code="linesall.type" text="Type" />:
                                        <c:if test="${localeCode == 'en'}">
                                        ${line.typeEn}
                                        </c:if>
                                        <c:if test="${localeCode == 'russia'}">
                                        ${line.typeRu}
                                        </c:if>
                                    </div>
                                    <div class="brand"><spring:message code="linesall.manufacturer" text="Manufacturer" />:
                                        <c:if test="${localeCode == 'en'}">
                                        ${line.manufacturerEn}
                                        </c:if>
                                        <c:if test="${localeCode == 'russia'}">
                                        ${line.manufacturerRu}
                                        </c:if>
                                    </div>                             
                                    <div class="brand"><spring:message code="linesall.workpiece_short" text="Workpiece" />: 
                                        <c:if test="${localeCode == 'en'}">
                                        ${line.workpieceEn}
                                        </c:if>
                                        <c:if test="${localeCode == 'russia'}">
                                        ${line.workpieceRu}
                                        </c:if>            
                                    </div>

                                </div>
                                <div class="prices">
                                    <sec:authorize access="hasRole('ROLE_USER')">
                                        <div class="price-current pull-right">${line.price}</div>
                                    </sec:authorize>
                                </div>
                                <div class="hover-area">
                                    <div class="add-cart-button">
                                        <a href="add-product-to-customer-basket?id=${line.id}&model=${line.modelEn}" class="le-button"><spring:message code="line.addtocart" text="add to cart" /></a>
                                    </div>
                                    <div class="wish-compare">
                                        <!--<a class="btn-add-to-wishlist" href="add-product-to-wish-list?id=${vmc.id}">add to wishlist</a>-->
                                        <a class="btn-add-to-compare" href="/compare-lines-add?id=${line.id}&pagereturn=${currentpagewithpage}"><spring:message code="linesall.compare" text="Compare" /></a>
                                    </div>
                                </div>
                                
                                
                            </div><!-- /.product-item -->
                        </div><!-- /.product-item-holder -->
                </c:forEach>
                        
                        

                            
                            
    <c:if test="${empty listAutomatedLine}">
        <div class="container-fluid">
            <div class="col-lg-10 center-block items-holder">
                <div class="inner-xs">
                    <div class="page-header">
                        <h2 class="page-title">
                            <spring:message code="linesall.nolines" text="There are no automated lines with such parameters<br/>Please, change the filter parameters."/>
                        </h2>
                    </div>
                </div>
            </div>
        </div>
    </c:if>         
                            
                            

                    </div><!-- /.row -->
                </div><!-- /.product-grid-holder -->
                
                
   
                
         <c:if test="${!empty listAutomatedLine}">      
                <div class="pagination-holder">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 text-left">
                            <ul class="pagination ">
                                <c:forEach begin="1" end="${allPage}" var="i">
                                    <li  <c:if test="${i == page}"> class="current" </c:if> >
                                        <a  href="${currentpagewithoutpage}&page=${i}">${i}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        
                        <div class="col-xs-12 col-sm-6">
                            <div class="result-counter">
                                Showing <span>1-9?</span> of <span>${itemsNum}</span> results
                            </div>
                        </div>

                    </div><!-- /.row -->
                </div>
        </c:if> 
                

            </div><!-- /.products-grid #grid-view -->

         
            
            
            
            
            <div id="list-view" class="products-grid fade tab-pane ">
                <div class="products-list">
                    
     <c:forEach items="${listAutomatedLine}" var="line">
        <div class="product-item product-item-holder">
            <!--<div class="ribbon red"><span>sale</span></div>--> 
            <div class="ribbon blue"><span>new!</span></div>
            <div class="row">
                <div class="no-margin col-xs-12 col-sm-4 image-holder">
                    <div class="image">
                        <a href="/line-${line.url}">
                            <c:forEach var="photo" items="${line.photos}" begin="0" end="0">
                                <img alt="${line.modelEn}" src="../resources/assets/images/blank.gif" 
                                data-echo="../resources/assets/images/products/${photo.name}" width="246" height="186" />
                            </c:forEach>
                        </a>
                    </div>
                </div><!-- /.image-holder -->
                <div class="no-margin col-xs-12 col-sm-5 body-holder">
                    <div class="body">
                        <div class="label-discount green">-10% sale</div>
                        <div class="title">
                            <a href="/line-${line.url}">
                                <c:if test="${localeCode == 'en'}">
                                    ${line.manufacturerEn} ${line.modelEn}
                                </c:if>
                                <c:if test="${localeCode == 'russia'}">
                                    ${line.manufacturerRu} ${line.modelRu}
                                </c:if>                                
                            </a>
                        </div>
                            <div class="brand">
                                <spring:message code="linesall.yearofmanuf" text="year"/>: ${line.yearOfManufacture}/
                                <spring:message code="linesall.location" text="location"/> 
                                <c:if test="${localeCode == 'en'}">
                                    ${line.machineLocationEn}
                                </c:if>
                                <c:if test="${localeCode == 'russia'}">
                                    ${line.machineLocationRu}
                                </c:if>                          
                                <br> L*B: ${line.length}x${line.width}
                            </div>
                            <!--<div class="brand"></div>-->
                        <div class="excerpt">
                            <p> </p>
                        </div>
                        <div class="addto-compare">
                            <!--<a class="btn-add-to-compare" href="/compare/light-office/add?id=${product.id}"><spring:message code="vmcs.addtocomparelist" text="add to compare list" /></a>-->
                        </div>
                    </div>
                </div><!-- /.body-holder -->
                <div class="no-margin col-xs-12 col-sm-3 price-area">
                    <div class="right-clmn">
        <!--                                    <div class="price-current">$1199.00</div>
                        <div class="price-prev">$1399.00</div>-->
                        <div class="availability"><label>availability:</label><span class="available">  in stock</span></div>
                        <!--<a class="le-button" href="add-product-to-customer-basket?id=${product.id}&model=${product.model}">add to cart</a>-->
                        <!--<a class="btn-add-to-wishlist" href="add-product-to-wish-list?id=${product.id}">add to wishlist</a>-->
                    </div>
                </div><!-- /.price-area -->
            </div><!-- /.row -->
        </div><!-- /.product-item -->

          </c:forEach> 
                        <!-- /.product-item -->

                </div><!-- /.products-list -->

 <c:if test="${!empty listAutomatedLine}">      
                <div class="pagination-holder">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 text-left">
                            <ul class="pagination ">
                                <c:forEach begin="1" end="${allPage}" var="i">
                                    <li  <c:if test="${i == page}"> class="current" </c:if> >
                                        <a  href="${currentpagewithoutpage}&page=${i}">${i}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        
                        <div class="col-xs-12 col-sm-6">
                            <div class="result-counter">
                                Showing <span>1-9</span> of <span>${itemsNum}</span> results
                            </div>
                        </div>

                    </div><!-- /.row -->
                </div>
        </c:if>

            </div><!-- /.products-grid #list-view -->

        </div><!-- /.tab-content -->
    </div><!-- /.grid-list-products -->

</section><!-- /#gaming -->            
        </div><!-- /.col -->
        <!-- ========================================= CONTENT : END ========================================= -->    
    </div><!-- /.container -->
</section><!-- /#category-grid -->    


<!-- ============================================================= FOOTER ============================================================= -->
<%@include file="/WEB-INF/pages/in/footer.jsp" %>
<!-- ============================================================= FOOTER : END ============================================================= -->   </div><!-- /.wrapper -->

    <!-- For demo purposes â can be removed on production -->      
                <!--!!!!! Do not forgot drop enpty new Message()-->
    <%@include file="/WEB-INF/pages/in/config_open.jsp" %>
    <!-- For demo purposes â can be removed on production : End -->

    <!-- JavaScripts placed at the end of the document so the pages load faster -->
    <script src="../resources/assets/js/jquery-1.10.2.min.js"></script>
    <script src="../resources/assets/js/jquery-migrate-1.2.1.js"></script>
    <script src="../resources/assets/js/bootstrap.min.js"></script>
    <script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
    <script src="../resources/assets/js/gmap3.min.js"></script>
    <script src="../resources/assets/js/bootstrap-hover-dropdown.min.js"></script>
    <script src="../resources/assets/js/owl.carousel.min.js"></script>
    <script src="../resources/assets/js/css_browser_selector.min.js"></script>
    <script src="../resources/assets/js/echo.min.js"></script>
    <script src="../resources/assets/js/jquery.easing-1.3.min.js"></script>
    <script src="../resources/assets/js/bootstrap-slider.min.js"></script>
    <script src="../resources/assets/js/jquery.raty.min.js"></script>
    <script src="../resources/assets/js/jquery.prettyPhoto.min.js"></script>
    <script src="../resources/assets/js/jquery.customSelect.min.js"></script>
    <script src="../resources/assets/js/wow.min.js"></script>
    <script src="../resources/assets/js/scripts.js"></script>

    <!-- For demo purposes â can be removed on production -->
    
    <script src="../resources/assets/switchstylesheet/switchstylesheet.js"></script>
    
    <script>
        $(document).ready(function(){ 
            $(".changecolor").switchstylesheet( { seperator:"color"} );
            $('.show-theme-options').click(function(){
                $(this).parent().toggleClass('open');
                return false;
            });
        });

        $(window).bind("load", function() {
           $('.show-theme-options').delay(2000).trigger('click');
        });
        
    </script>
    <!-- For demo purposes â can be removed on production : End -->

    <script src="http://w.sharethis.com/button/buttons.js"></script>

</body>
</html>