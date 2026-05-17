<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <%@include file="importBootstrap.jsp" %>
    <title id="pageTitle"></title>
</head>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a href="/Home/Homepage.jsp" style="text-decoration: none;">
        </a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 90%;">
                <%
                    
                %>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        AAAAAAAAAA
                    </a>
                    <ul class="dropdown-menu">
                        
                        <li class="text-center">
                            <form style="display: none" action="/Serveo" method="post">
                                <input type="hidden" name="action" value="lst">
                                <input type="hidden" name="path"
                                       value="/app/">
                                <input type="hidden" name="item" value="">
                                <button type="submit" id=""> </button>
                            </form>
                            <a id="A2"><label for=""></label></a>
                        </li>
                        
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>
</nav>
