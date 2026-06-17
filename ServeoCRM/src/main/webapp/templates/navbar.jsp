<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <%@include file="tailwind.jsp" %>

</head>

<!-- navbar goes here -->
<nav class="bg-gray-100">
    <div class="max-w-6xl mx-auto px-4">
        <div class="flex justify-between">

            <div class="flex space-x-4">
                <!-- logo -->
                <div>
                    <a href="${pageContext.request.contextPath}" class="flex items-center py-5 px-2 text-gray-700 hover:text-gray-900">
                        <svg class="h-6 w-6 mr-1 text-blue-400" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 19l9 2-9-18-9 18 9-2zm0 0v-8" />
                        </svg>
                        <span class="font-bold">${pageContext.request.contextPath}</span>
                    </a>
                </div>

                <!-- Admin -->
                    
                <!-- Customer -->
                    
                <!-- Employee -->
                <div class="hidden md:flex items-center space-x-1">
                    <form style="display: none" action="${pageContext.request.contextPath}/Employee" method="post">
                        <input type="hidden" name="action" value="lst"/>
                        <input type="hidden" name="item" value="customer"/>
                        <button type="submit" id="Customers"></button>
                    </form>
                    <a><label for="Customers">Customers</label></a>
                    
                    <form style="display: none" action="${pageContext.request.contextPath}/Employee" method="post">
                        <input type="hidden" name="action" value="lst"/>
                        <input type="hidden" name="item" value="employee"/>
                        <button type="submit" id="Employees"></button>
                    </form>
                    <a><label for="Employees">Employees</label></a>
                    
                    <form style="display: none" action="${pageContext.request.contextPath}/Employee" method="post">
                        <input type="hidden" name="action" value="lst"/>
                        <input type="hidden" name="item" value="ingredient"/>
                        <button type="submit" id="Ingredients"></button>
                    </form>
                    <a><label for="Ingredients">Ingredients</label></a>
                    
                    <form style="display: none" action="${pageContext.request.contextPath}/Employee" method="post">
                        <input type="hidden" name="action" value="lst"/>
                        <input type="hidden" name="item" value="supplier"/>
                        <button type="submit" id="Suppliers"></button>
                    </form>
                    <a><label for="Suppliers">Suppliers</label></a>
                    
                    <form style="display: none" action="${pageContext.request.contextPath}/Employee" method="post">
                        <input type="hidden" name="action" value="lst"/>
                        <input type="hidden" name="item" value="supplies"/>
                        <button type="submit" id="Supplies"></button>
                    </form>
                    <a><label for="Supplies">Supplies</label></a>
                </div>
                <!-- IT Support -->
                <!-- Login -->
                
            </div>

            <!-- secondary nav -->
            <div class="hidden md:flex items-center space-x-1">
                <form style="display: none" action="${pageContext.request.contextPath}/Login" method="post">
                    <input type="hidden" name="action" value="login"/>
                    <input type="hidden" name="item" value="login"/>
                    <button type="submit" id="Login"></button>
                </form>
                <a><label for="Login">Login</label></a>
            </div>

            <!-- mobile button goes here -->
            <div class="md:hidden flex items-center">
                <button class="mobile-menu-button">
                    <svg class="w-6 h-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
                    </svg>
                </button>
            </div>

        </div>
    </div>

    <!-- mobile menu -->
    <div class="mobile-menu hidden md:hidden">
        <a href="${pageContext.request.contextPath}/Home/Employees.jsp" class="block py-2 px-4 text-sm hover:bg-gray-200">Employee List</a>
        <a href="${pageContext.request.contextPath}/Home/Customers.jsp" class="block py-2 px-4 text-sm hover:bg-gray-200">Customer List</a>
        <a href="${pageContext.request.contextPath}/Home/EmployeeHome.jsp" class="block py-2 px-4 text-sm hover:bg-gray-200">Employee Homepage</a>
    </div>
</nav>

<!-- content goes here -->

</nav>

<script>
    // grab everything we need
    const btn = document.querySelector("button.mobile-menu-button");
    const menu = document.querySelector(".mobile-menu");

    // add event listeners
    btn.addEventListener("click", () => {
        menu.classList.toggle("hidden");
    });


</script>