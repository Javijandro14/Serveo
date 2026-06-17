<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="../../templates/navbar.jsp" %>
    </head>
    <body>
        <form action="/ServeoCRM/Login" method="POST" class="max-w-sm mx-auto">
            <input type="hidden" name="action" value="login">
            <div class="mb-5">
                <label for="username" class="block mb-2.5 text-sm font-medium text-heading">Username</label>
                <input type="username" name="username" id="username" class="bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand block w-full px-3 py-2.5 shadow-xs placeholder:text-body" placeholder="Username" required />
            </div>
            <div class="mb-5">
                <label for="password" class="block mb-2.5 text-sm font-medium text-heading">Your password</label>
                <input type="password" name="password" id="password" class="bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand block w-full px-3 py-2.5 shadow-xs placeholder:text-body" placeholder="••••••••" required />
            </div>
            <div class="mb-5">
                <label for="item" class="block mb-2.5 text-sm font-medium text-heading">Select an option</label>
                <select id="item" name="item" class="block w-full px-3 py-2.5 bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand shadow-xs placeholder:text-body">
                    <option disabled selected>Choose</option>
                    <option value="employee">Employee</option>
                    <option value="customer">Customer</option>
                </select>
            </div>
            <button type="submit" class="text-white bg-gradient-to-r from-green-400 via-green-500 to-green-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-green-300 dark:focus:ring-green-800 shadow-lg shadow-green-500/50 dark:shadow-lg dark:shadow-green-800/80 font-medium rounded-base text-sm px-4 py-2.5 text-center leading-5">Login</button>
        </form>
    </body>
</html>
