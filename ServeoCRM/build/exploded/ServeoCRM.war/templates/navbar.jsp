<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <%@include file="tailwind.jsp" %>
    <title id="pageTitle"></title>
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

        <!-- primary nav -->
        <div class="hidden md:flex items-center space-x-1">
          <a href="${pageContext.request.contextPath}/Home/Employees.jsp" class="py-5 px-3 text-gray-700 hover:text-gray-900">Employee List</a>
          <a href="${pageContext.request.contextPath}/Home/Customers.jsp" class="py-5 px-3 text-gray-700 hover:text-gray-900">Customer List</a>
          <a href="${pageContext.request.contextPath}/Home/EmployeeHome.jsp" class="py-5 px-3 text-gray-700 hover:text-gray-900">Employee Homepage</a>
        </div>
      </div>

      <!-- secondary nav -->
      <div class="hidden md:flex items-center space-x-1">
        <a href="${pageContext.request.contextPath}/Home/Login.jsp" class="py-5 px-3">Login</a>
        <a href="" class="py-2 px-3 bg-yellow-400 hover:bg-yellow-300 text-yellow-900 hover:text-blue-800 rounded transition duration-300">Signup</a>
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