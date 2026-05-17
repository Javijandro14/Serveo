package dao;

import config.DbConnection;

import java.sql.ResultSet;

public class DaoMaintenance {
    
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
/*
    Area area = new Area();
    Branch branch = new Branch();
    Menu menu = new Menu();
    Category category = new Category();
    Product product = new Product();
    Shift shift = new Shift();
    Table table = new Table();
    Status status = new Status();
    
    public List<Area> listAreas() {
        List<Area> lstArea = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT A.IDAREA, A.DESCRIPTION, B.NAME AS 'BRANCH', S.NAME AS 'STATUS', A.MODDATE, A.CREATEDATE FROM AREAS A, BRANCHES B, STATUS S WHERE A.IDBRANCH = B.IDBRANCH AND A.IDSTATUS = S.IDSTATUS");
            while (rs.next()) {
                area = new Area();
                area.setIdArea(rs.getInt("IDAREA"));
                area.setDescription(rs.getString("DESCRIPTION"));
                area.setBranch(rs.getString("BRANCH"));
                area.setStatus(rs.getString("STATUS"));
                area.setModDate(rs.getString("MODDATE"));
                area.setCreateDate(rs.getString("CREATEDATE"));
                lstArea.add(area);
            }
            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstArea;
    }
    public boolean createArea(Area area) {return crud("INSERT INTO [dbo].[AREAS]([IDAREA],[DESCRIPTION],[IDBRANCH],[IDSTATUS],[MODDATE],[CREATEDATE]) VALUES((SELECT MAX(IDAREA)+1 FROM [AREAS]),'"+area.getDescription()+"',"+area.getIdBranch()+","+area.getIdStatus()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");}
    public boolean updateArea(Area area) {return crud("UPDATE [dbo].[AREAS] SET [DESCRIPTION] = '"+area.getDescription()+"',[IDBRANCH] = "+area.getIdBranch()+",[IDSTATUS] = "+area.getIdStatus()+",[MODDATE] = CONVERT(DATE,GETDATE()) WHERE [IDAREA] = "+area.getIdArea());}
    public boolean deleteArea(Area area) {return crud("DELETE FROM [dbo].[AREAS] WHERE IDAREA = "+area.getIdArea());}
    
    public List<Branch> listBranches() {
        List<Branch> lstBranch = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT B.IDBRANCH, B.NAME, B.ADDRESS, B.TEL, B.BUSINESSHOURS, B.MODDATE, B.CREATEDATE FROM BRANCHES B");
            while (rs.next()) {
                branch = new Branch();
                branch.setIdBranch(rs.getInt("IDBRANCH"));
                branch.setName(rs.getString("NAME"));
                branch.setAddress(rs.getString("ADDRESS"));
                branch.setTel(rs.getString("TEL"));
                branch.setBusinessHour(rs.getString("BUSINESSHOURS"));
                branch.setModDate(rs.getString("MODDATE"));
                branch.setCreateDate(rs.getString("CREATEDATE"));
                lstBranch.add(branch);
            }
            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstBranch;
    }
    public boolean createBranch(Branch branch) {return crud("INSERT INTO [dbo].[BRANCHES]([IDBRANCH],[NAME],[ADDRESS],[TEL],[BUSINESSHOURS],[MODDATE],[CREATEDATE]) VALUES((SELECT MAX(IDBRANCH)+1 FROM [BRANCHES]),'"+branch.getName()+"','"+branch.getAddress()+"','"+branch.getTel()+"','"+branch.getBusinessHour()+"',CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");}
    public boolean updateBranch(Branch branch) {return crud("UPDATE [dbo].[BRANCHES] SET [NAME] = '"+branch.getName()+"',[ADDRESS] = '"+branch.getAddress()+"',[TEL] = '"+branch.getTel()+"',[BUSINESSHOURS] = '"+branch.getBusinessHour()+"',[MODDATE] = CONVERT(DATE,GETDATE()) WHERE [IDBRANCH] = "+branch.getIdBranch()+"");}
    public boolean deleteBranch(Branch branch) {return crud("DELETE FROM [dbo].[BRANCHES] WHERE IDBRANCH = "+branch.getIdBranch());}
    
    public List<Menu> listMenus() {
        List<Menu> lstMenu = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT M.IDMENU, M.NAME AS 'MENU', M.DESCRIPTION, M.PRICE, S.NAME AS 'STATUS', C.NAME AS 'CATEGORY', M.MODDATE, M.CREATEDATE FROM MENUS M, STATUS S, CATEGORIES C WHERE M.IDSTATUS = S.IDSTATUS AND M.IDCATEGORY = C.IDCATEGORY");
            while (rs.next()) {
                menu = new Menu();
                menu.setIdMenu(rs.getInt("IDMENU"));
                menu.setName(rs.getString("MENU"));
                menu.setDescription(rs.getString("DESCRIPTION"));
                menu.setPrice(rs.getDouble("PRICE"));
                menu.setCategory(rs.getString("CATEGORY"));
                menu.setStatus(rs.getString("STATUS"));
                menu.setModDate(rs.getString("MODDATE"));
                menu.setCreateDate(rs.getString("CREATEDATE"));
                lstMenu.add(menu);
            }
            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstMenu;
    }
    public boolean createMenu(Menu menu) {return crud("INSERT INTO [dbo].[MENUS]([IDMENU],[NAME],[DESCRIPTION],[PRICE],[IDSTATUS],[IDCATEGORY],[MODDATE],[CREATEDATE]) VALUES((SELECT MAX(IDMENU)+1 FROM [MENUS]),'"+menu.getName()+"','"+menu.getDescription()+"',"+menu.getPrice()+","+menu.getIdStatus()+","+menu.getIdCategory()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");}
    public boolean updateMenu(Menu menu) {return crud("UPDATE [dbo].[MENUS] SET [NAME] = '"+menu.getName()+"',[DESCRIPTION] = '"+menu.getDescription()+"',[PRICE] = "+menu.getPrice()+",[IDSTATUS] = "+menu.getIdStatus()+",[IDCATEGORY] = "+menu.getIdCategory()+",[MODDATE] = CONVERT(DATE,GETDATE()) WHERE [IDMENU] = "+menu.getIdMenu());}
    public boolean deleteMenu(Menu menu) {return crud("DELETE FROM [MENUS] WHERE IDMENU = "+menu.getIdMenu());}
    
    public List<Category> listCategories() {
        List<Category> lstCategory = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT C.IDCATEGORY, C.NAME AS 'CATEGORY', C.TYPE, C.MODDATE, C.CREATEDATE FROM CATEGORIES C");
            while (rs.next()) {
                category = new Category();
                category.setIdCategory(rs.getInt("IDCATEGORY"));
                category.setName(rs.getString("CATEGORY"));
                category.setType(rs.getString("TYPE"));
                category.setModDate(rs.getString("MODDATE"));
                category.setCreateDate(rs.getString("CREATEDATE"));
                lstCategory.add(category);
            }
            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstCategory;
    }
    public boolean createCategory(Category category) {return crud("INSERT INTO [dbo].[CATEGORIES]([IDCATEGORY],[NAME],[TYPE],[MODDATE],[CREATEDATE]) VALUES((SELECT MAX(IDCATEGORY)+1 FROM [CATEGORIES]),'"+category.getName()+"','"+category.getType()+"',CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");}
    public boolean updateCategory(Category category) {return crud("UPDATE [dbo].[CATEGORIES] SET [NAME] = '"+category.getName()+"',[TYPE] = '"+category.getType()+"',[MODDATE] = CONVERT(DATE,GETDATE()) WHERE [IDCATEGORY] = "+category.getIdCategory());}
    public boolean deleteCategory(Category category) {return crud("DELETE FROM [CATEGORIES] WHERE IDCATEGORY= "+category.getIdCategory());}
    
    public List<Product> listProducts() {
        List<Product> lstProduct = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT P.IDPRODUCT, P.NAME AS 'PRODUCT', P.DESCRIPTION, P.STOCK, C.NAME AS 'CATEGORY', V.NAME AS 'VENDOR', S.NAME AS 'STATUS', P.MEASURE, P.MODDATE, P.CREATEDATE FROM PRODUCTS P, CATEGORIES C, VENDORS V, STATUS S WHERE P.IDCATEGORY = C.IDCATEGORY AND P.IDVENDOR = V.IDVENDOR AND P.IDSTATUS = S.IDSTATUS;");
            while (rs.next()) {
                product = new Product();
                product.setIdProduct(rs.getInt("IDPRODUCT"));
                product.setName(rs.getString("PRODUCT"));
                product.setDescription(rs.getString("DESCRIPTION"));
                product.setMeasure(rs.getString("MEASURE"));
                product.setCategory(rs.getString("CATEGORY"));
                product.setVendor(rs.getString("VENDOR"));
                product.setStock(rs.getInt("STOCK"));
                product.setModDate(rs.getString("MODDATE"));
                product.setCreateDate(rs.getString("CREATEDATE"));
                lstProduct.add(product);
            }
            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstProduct;
    }
    public boolean createProduct(Product product) {return crud("INSERT INTO [dbo].[PRODUCTS]([IDPRODUCT],[NAME],[DESCRIPTION],[STOCK],[IDCATEGORY],[IDVENDOR],[IDSTATUS],[MEASURE],[MODDATE],[CREATEDATE]) VALUES((SELECT MAX(IDPRODUCT)+1 FROM [PRODUCTS]),'"+product.getName()+"','"+product.getDescription()+"','"+product.getStock()+"','"+product.getIdCategory()+"','"+product.getIdVendor()+"','"+product.getIdStatus()+"','"+product.getMeasure()+"',CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");}
    public boolean updateProduct(Product product) {return crud("UPDATE [dbo].[PRODUCTS] SET [NAME] = '"+product.getName()+"' ,[DESCRIPTION] = '"+product.getDescription()+"' ,[STOCK] = "+product.getStock()+" ,[IDCATEGORY] = "+product.getIdCategory()+" ,[IDVENDOR] = "+product.getIdVendor()+" ,[IDSTATUS] = "+product.getIdStatus()+" ,[MEASURE] = '"+product.getMeasure()+"' ,[MODDATE] = CONVERT(DATE,GETDATE())  WHERE [IDPRODUCT] = "+ product.getIdProduct());}
    public boolean deleteProduct(Product product){return crud("DELETE FROM [PRODUCTS] WHERE IDPRODUCT= "+product.getIdProduct());}

    public List<Table> listTables() {
        List<Table> lstTable = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT T.IDTABLE, T.DESCRIPTION, A.DESCRIPTION AS 'AREA', T.CAPACITY, S.NAME AS 'STATUS', T.MODDATE, T.CREATEDATE FROM TABLES T, AREAS A, STATUS S WHERE T.IDAREA = A.IDAREA AND T.IDSTATUS = S.IDSTATUS");
            while (rs.next()) {
                table = new Table();
                table.setIdTable(rs.getInt("IDTABLE"));
                table.setArea(rs.getString("AREA"));
                table.setCapacity(rs.getInt("CAPACITY"));
                table.setDescription(rs.getString("DESCRIPTION"));
                table.setStatus(rs.getString("STATUS"));
                table.setModDate(rs.getString("MODDATE"));
                table.setCreateDate(rs.getString("CREATEDATE"));
                lstTable.add(table);
            }
            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstTable;
    }
    public boolean createTable(Table table) {return crud("INSERT INTO [dbo].[TABLES]([IDTABLE],[DESCRIPTION],[IDAREA],[CAPACITY],[IDSTATUS],[MODDATE],[CREATEDATE]) VALUES((SELECT MAX(IDTABLE)+1 FROM [TABLES]),'"+table.getDescription()+"',"+table.getIdArea()+","+table.getCapacity()+","+table.getIdStatus()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");}
    public boolean updateTable(Table table) {return crud("UPDATE [dbo].[TABLES] SET [DESCRIPTION] = '"+table.getDescription()+"' ,[IDAREA] = "+table.getIdArea()+" ,[CAPACITY] = "+table.getCapacity()+" ,[IDSTATUS] = "+table.getIdStatus()+" ,[MODDATE] = CONVERT(DATE,GETDATE())  WHERE [IDTABLE] = "+table.getIdTable()+"");}
    public boolean deleteTable(Table table){return crud("DELETE FROM [TABLES] WHERE IDTABLE = "+table.getIdTable());}
    
    public List<Status> listStatus() {
        List<Status> lstStatus = new ArrayList<>();
        try {
            con.open(); 
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                status = new Status();
                status.setIdStatus(rs.getInt("IDSTATUS"));
                status.setName(rs.getString("NAME"));
                status.setType(rs.getString("TYPE"));
                status.setModDate(rs.getString("MODDATE"));
                status.setCreateDate(rs.getString("CREATEDATE"));
                lstStatus.add(status);
            }
            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstStatus;
    }
    public boolean createStatus(Status status) {return crud("INSERT INTO [dbo].[STATUS]([IDSTATUS],[NAME],[TYPE],[MODDATE],[CREATEDATE]) VALUES((SELECT MAX(IDSTATUS)+1 FROM [STATUS]),'"+status.getName()+"','"+status.getType()+"',CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");}
    public boolean updateStatus(Status status) {return crud("UPDATE [dbo].[STATUS] SET [NAME] = '"+status.getName()+"' ,[TYPE] = '"+status.getType()+"' ,[MODDATE] = CONVERT(DATE,GETDATE())  WHERE [IDSTATUS] = "+status.getIdStatus());}
    public boolean deleteStatus(Status status) {return crud("DELETE FROM [STATUS] WHERE IDSTATUS= "+status.getIdStatus());}

    public boolean crud(String strSql){
        try {
            con.open();
            res = con.executeSql(strSql);
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    */
}