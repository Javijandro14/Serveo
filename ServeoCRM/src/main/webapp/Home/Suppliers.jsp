<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../templates/navbar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
    </head>
    <body>
        <div class="grid grid-cols-12 gap-4">
            <div class="col-span-10"></div>
            <div class="col-span-2"><button data-modal-target="crud-modal" data-modal-show="crud-modal" onclick="createRow()" type="button">Create</button></div>
            <div class="col-span-1"></div>
            <div class="col-span-10 col-start-2 overflow-x-auto bg-gray-200 shadow-xs rounded-base border border-default">
                <table class="relative top-0 left-0 w-full text-sm text-left rtl:text-right text-body">
                    <thead class="text-sm text-body bg-neutral-secondary-medium border-b border-default-medium">
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">Employee ID</th>
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">Username</th>
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">First Name</th>
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">Last Name</th>
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">Job Title</th>
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">Hourly Rate</th>
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">Hire Date</th>
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">Last Modified</th>
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">Create Date</th>
                    <th scope="col" class="px-6 py-3 font-medium" id="disabled">Actions</th>

                    </thead>
                    <tbody>
                        <tr class="bg-neutral-primary-soft border-b  border-default">
                            <th scope="row" class="px-6 py-4 font-medium text-heading whitespace-nowrap"> Apple MacBook Pro 17" </th>
                            <td class="px-6 py-4"> Silver </td> 
                            <td class="px-6 py-4"> Laptop </td>
                            <td class="px-6 py-4"> $2999 </td>
                            <td class="px-6 py-4"> $2999 </td>
                            <td class="px-6 py-4"> $2999 </td>
                            <td class="px-6 py-4"> $2999 </td>
                            <td class="px-6 py-4"> $2999 </td>
                            <td class="px-6 py-4"> $2999 </td>
                            <td class="px-6 py-4 text-right">
                                <!-- Modal toggle -->

                                <button data-modal-target="crud-modal" data-modal-show="crud-modal" onclick="editRow()" type="button" class="text-warning bg-red border border-warning hover:bg-warning hover:text-white focus:ring-4 focus:ring-neutral-tertiary font-medium leading-5 rounded-base text-sm px-4 py-2.5 focus:outline-none">
                                    Edit</button>
                                <button data-modal-target="crud-modal" data-modal-show="crud-modal" onclick== "deleteRow()" type="button" class="text-danger bg-red border border-danger hover:bg-danger hover:text-white focus:ring-4 focus:ring-neutral-tertiary font-medium leading-5 rounded-base text-sm px-4 py-2.5 focus:outline-none">
                                    Delete</button>
                            </td>
                        </tr>
                        <!-- Input Java Code Here  -->

                        <!-- Input Java Code END  -->
                    </tbody>
                </table>
            </div>
        </div>
        <!-- Main modal -->
        <div id="crud-modal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden bg-gray-950/80 fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
            <div class="relative p-4 w-full max-w-md max-h-full">
                <!-- Modal content -->
                <div class="relative bg-white border border-default rounded-base shadow-sm p-4 md:p-6">
                    <!-- Modal header -->
                    <div class="flex items-center justify-between border-b border-default pb-4 md:pb-5">
                        <h3 id="modalTitle" class="text-lg font-medium text-heading">Create new product</h3>
                        <button type="button" class="text-body bg-transparent hover:bg-neutral-tertiary hover:text-heading rounded-base text-sm w-9 h-9 ms-auto inline-flex justify-center items-center" data-modal-hide="crud-modal"><svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18 17.94 6M18 18 6.06 6"/></svg><span class="sr-only">Close modal</span></button>
                    </div>
                    <!-- Modal body -->
                    <form action="#">
                        <div class="grid gap-4 grid-cols-2 py-4 md:py-6">
                            <div class="col-span-2">
                                <label for="name" class="block mb-2.5 text-sm font-medium text-heading">Name</label>
                                <input type="text" name="name" id="name" class="bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand block w-full px-3 py-2.5 shadow-xs placeholder:text-body" placeholder="Type product name" required="">
                            </div>
                            <div class="col-span-2 sm:col-span-1">
                                <label for="price" class="block mb-2.5 text-sm font-medium text-heading">Price</label>
                                <input type="number" name="price" id="price" class="bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand block w-full px-3 py-2.5 shadow-xs placeholder:text-body" placeholder="$2999" required="">
                            </div>
                            <div class="col-span-2 sm:col-span-1">
                                <label for="category" class="block mb-2.5 text-sm font-medium text-heading">Category</label>
                                <select id="category" class="block w-full px-3 py-2.5 bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand px-3 py-2.5 shadow-xs placeholder:text-body">
                                    <option selected="">Select category</option>
                                    <option value="TV">TV/Monitors</option>
                                    <option value="PC">PC</option>
                                    <option value="GA">Gaming/Console</option>
                                    <option value="PH">Phones</option>
                                </select>
                            </div>
                            <div class="col-span-2">
                                <label for="description" class="block mb-2.5 text-sm font-medium text-heading">Product Description</label>
                                <textarea id="description" rows="4" class="block bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand block w-full p-3.5 shadow-xs placeholder:text-body" placeholder="Write product description here"></textarea>                    
                            </div>
                        </div>
                        <div class="flex items-center space-x-4 border-t border-default pt-4 md:pt-6">
                            <button type="submit" class="inline-flex items-center  text-white bg-brand hover:bg-brand-strong box-border border border-transparent focus:ring-4 focus:ring-brand-medium shadow-xs font-medium leading-5 rounded-base text-sm px-4 py-2.5 focus:outline-none">
                                <svg class="w-4 h-4 me-1.5 -ms-0.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 12h14m-7 7V5"/></svg>
                                Add new product
                            </button>
                            <button data-modal-hide="crud-modal" type="button" class="text-body bg-neutral-secondary-medium box-border border border-default-medium hover:bg-neutral-tertiary-medium hover:text-heading focus:ring-4 focus:ring-neutral-tertiary shadow-xs font-medium leading-5 rounded-base text-sm px-4 py-2.5 focus:outline-none">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div> 
    </body>
</html>
