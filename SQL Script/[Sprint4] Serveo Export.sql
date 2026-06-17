--
-- PostgreSQL database dump
--

\restrict ssNYmicxjgWVthHtBRbFyypXrIVpUJL9Hh0xYinYjoRP54K6AIY58Skggiwv815

-- Dumped from database version 18.4
-- Dumped by pg_dump version 18.4

-- Started on 2026-06-12 10:07:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5063 (class 1262 OID 16389)
-- Name: serveoCRM; Type: DATABASE; Schema: -; Owner: serveoAdmin
--

CREATE DATABASE "serveoCRM" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


ALTER DATABASE "serveoCRM" OWNER TO "serveoAdmin";

\unrestrict ssNYmicxjgWVthHtBRbFyypXrIVpUJL9Hh0xYinYjoRP54K6AIY58Skggiwv815
\connect "serveoCRM"
\restrict ssNYmicxjgWVthHtBRbFyypXrIVpUJL9Hh0xYinYjoRP54K6AIY58Skggiwv815

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 5064 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 16448)
-- Name: TBL_CUSTOMERS; Type: TABLE; Schema: public; Owner: serveoAdmin
--

CREATE TABLE public."TBL_CUSTOMERS" (
    "CUSTOMER_ID" integer NOT NULL,
    "USER_ID" integer NOT NULL,
    "FIRST_NAME" character varying(30) NOT NULL,
    "LAST_NAME" character varying(30) NOT NULL,
    "CREATE_DATE" date NOT NULL,
    "MOD_DATE" date NOT NULL
);


ALTER TABLE public."TBL_CUSTOMERS" OWNER TO "serveoAdmin";

--
-- TOC entry 221 (class 1259 OID 16428)
-- Name: TBL_EMPLOYEES; Type: TABLE; Schema: public; Owner: serveoAdmin
--

CREATE TABLE public."TBL_EMPLOYEES" (
    "EMPLOYEE_ID" integer NOT NULL,
    "USER_ID" integer NOT NULL,
    "FIRST_NAME" character varying(30) NOT NULL,
    "LAST_NAME" character varying(30) NOT NULL,
    "POSITION" character varying(30) NOT NULL,
    "HOURLY_RATE" double precision NOT NULL,
    "STATUS" character varying(30) NOT NULL,
    "HIRE_DATE" date NOT NULL,
    "CREATE_DATE" date NOT NULL,
    "MOD_DATE" date NOT NULL
);


ALTER TABLE public."TBL_EMPLOYEES" OWNER TO "serveoAdmin";

--
-- TOC entry 223 (class 1259 OID 24582)
-- Name: TBL_INGREDIENTS; Type: TABLE; Schema: public; Owner: serveoAdmin
--

CREATE TABLE public."TBL_INGREDIENTS" (
    "INGREDIENT_ID" integer NOT NULL,
    "SUPPLIER_ID" integer NOT NULL,
    "NAME" character varying(30) NOT NULL,
    "QUANTITY" integer NOT NULL,
    "UNIT" character varying(15) NOT NULL,
    "CREATE_DATE" date NOT NULL,
    "MOD_DATE" date NOT NULL
);


ALTER TABLE public."TBL_INGREDIENTS" OWNER TO "serveoAdmin";

--
-- TOC entry 219 (class 1259 OID 16390)
-- Name: TBL_ROLES; Type: TABLE; Schema: public; Owner: serveoAdmin
--

CREATE TABLE public."TBL_ROLES" (
    "ROLE_ID" integer NOT NULL,
    "NAME" character varying(50) NOT NULL,
    "DESCRIPTION" character varying(100) NOT NULL,
    "CREATE_DATE" date NOT NULL,
    "MOD_DATE" date NOT NULL
);


ALTER TABLE public."TBL_ROLES" OWNER TO "serveoAdmin";

--
-- TOC entry 224 (class 1259 OID 24594)
-- Name: TBL_SUPPLIERS; Type: TABLE; Schema: public; Owner: serveoAdmin
--

CREATE TABLE public."TBL_SUPPLIERS" (
    "SUPPLIER_ID" integer NOT NULL,
    "NAME" character varying(50) NOT NULL,
    "PHONE_NO" character varying(15) NOT NULL,
    "EMAIL" character varying(50) NOT NULL,
    "DESCRIPTION" text NOT NULL,
    "CREATE_DATE" date NOT NULL,
    "MOD_DATE" date NOT NULL
);


ALTER TABLE public."TBL_SUPPLIERS" OWNER TO "serveoAdmin";

--
-- TOC entry 225 (class 1259 OID 24613)
-- Name: TBL_SUPPLIES; Type: TABLE; Schema: public; Owner: serveoAdmin
--

CREATE TABLE public."TBL_SUPPLIES" (
    "ITEM_ID" integer NOT NULL,
    "SUPPLIER_ID" integer NOT NULL,
    "NAME" character varying(30) NOT NULL,
    "QUANTITY" integer NOT NULL,
    "UNIT" character varying(20) NOT NULL,
    "CREATE_DATE" date NOT NULL,
    "MOD_DATE" date NOT NULL
);


ALTER TABLE public."TBL_SUPPLIES" OWNER TO "serveoAdmin";

--
-- TOC entry 220 (class 1259 OID 16402)
-- Name: TBL_USERS; Type: TABLE; Schema: public; Owner: serveoAdmin
--

CREATE TABLE public."TBL_USERS" (
    "USER_ID" integer NOT NULL,
    "ROLE_ID" integer NOT NULL,
    "USERNAME" character varying(20) NOT NULL,
    "EMAIL" character varying(50) NOT NULL,
    "PHONE" character varying(15) NOT NULL,
    "PASSWORD_HASH" text NOT NULL,
    "CREATE_DATE" date NOT NULL,
    "MOD_DATE" date NOT NULL
);


ALTER TABLE public."TBL_USERS" OWNER TO "serveoAdmin";

--
-- TOC entry 5054 (class 0 OID 16448)
-- Dependencies: 222
-- Data for Name: TBL_CUSTOMERS; Type: TABLE DATA; Schema: public; Owner: serveoAdmin
--

INSERT INTO public."TBL_CUSTOMERS" VALUES (1, 1, 'JOHN', 'DOE', '2026-06-08', '2026-06-08');
INSERT INTO public."TBL_CUSTOMERS" VALUES (2, 1, 'A', 'B', '2026-06-11', '2026-06-11');


--
-- TOC entry 5053 (class 0 OID 16428)
-- Dependencies: 221
-- Data for Name: TBL_EMPLOYEES; Type: TABLE DATA; Schema: public; Owner: serveoAdmin
--



--
-- TOC entry 5055 (class 0 OID 24582)
-- Dependencies: 223
-- Data for Name: TBL_INGREDIENTS; Type: TABLE DATA; Schema: public; Owner: serveoAdmin
--

INSERT INTO public."TBL_INGREDIENTS" VALUES (1, 1, 'All-Purpose Flour', 8, 'Bags', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (2, 1, 'All-Purpose Flour', 8, 'Bags', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (3, 1, 'Granulated Sugar', 5, 'Bags', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (4, 1, 'Brown Sugar', 3, 'Bags', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (5, 1, 'Salt', 4, 'Bags', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (6, 1, 'Black Pepper', 2, 'Containers', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (7, 1, 'Olive Oil', 6, 'Jugs', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (8, 1, 'Vegetable Oil', 8, 'Jugs', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (9, 1, 'Butter', 10, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (10, 1, 'Milk', 12, 'Crates', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (11, 1, 'Heavy Cream', 4, 'Cartons', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (12, 1, 'Eggs', 20, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (13, 1, 'Cheddar Cheese', 6, 'Blocks', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (14, 1, 'Mozzarella Cheese', 8, 'Blocks', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (15, 1, 'Parmesan Cheese', 4, 'Containers', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (16, 1, 'Chicken Breast', 10, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (17, 1, 'Ground Beef', 8, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (18, 1, 'Bacon', 6, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (19, 1, 'Salmon Fillets', 4, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (20, 1, 'Shrimp', 5, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (21, 1, 'White Rice', 10, 'Bags', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (22, 1, 'Pasta', 12, 'Boxes', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (23, 1, 'Potatoes', 15, 'Bags', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (24, 1, 'Yellow Onions', 10, 'Bags', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (25, 1, 'Garlic', 4, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (26, 1, 'Tomatoes', 12, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (27, 1, 'Romaine Lettuce', 8, 'Crates', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (28, 1, 'Spinach', 6, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (29, 1, 'Bell Peppers', 7, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (30, 1, 'Carrots', 5, 'Bags', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (31, 1, 'Celery', 4, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (32, 1, 'Broccoli', 6, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (33, 1, 'Mushrooms', 5, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (34, 1, 'Lemons', 4, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (35, 1, 'Limes', 5, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (36, 1, 'Avocados', 6, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (37, 1, 'Apples', 5, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (38, 1, 'Bananas', 4, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (39, 1, 'Strawberries', 3, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (40, 1, 'Chicken Stock', 6, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (41, 1, 'Beef Stock', 4, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (42, 1, 'Soy Sauce', 3, 'Jugs', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (43, 1, 'Ketchup', 4, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (44, 1, 'Mayonnaise', 3, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (45, 1, 'Mustard', 2, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (46, 1, 'Hot Sauce', 2, 'Cases', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (47, 1, 'Honey', 2, 'Jugs', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (48, 1, 'Cornstarch', 3, 'Boxes', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (49, 1, 'Baking Powder', 2, 'Boxes', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (50, 1, 'Baking Soda', 2, 'Boxes', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_INGREDIENTS" VALUES (51, 1, 'Vanilla Extract', 1, 'Case', '2026-06-11', '2026-06-11');


--
-- TOC entry 5051 (class 0 OID 16390)
-- Dependencies: 219
-- Data for Name: TBL_ROLES; Type: TABLE DATA; Schema: public; Owner: serveoAdmin
--

INSERT INTO public."TBL_ROLES" VALUES (1, 'TEST', 'TEST ROLE FOR DB', '2026-06-08', '2026-06-08');


--
-- TOC entry 5056 (class 0 OID 24594)
-- Dependencies: 224
-- Data for Name: TBL_SUPPLIERS; Type: TABLE DATA; Schema: public; Owner: serveoAdmin
--

INSERT INTO public."TBL_SUPPLIERS" VALUES (1, 'Fresh Harvest Foods', '5551000001', 'sales@freshharvestfoods.com', 'Provides fresh fruits and vegetables sourced from regional farms. Offers seasonal produce programs and scheduled deliveries for restaurants.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (2, 'Fresh Harvest Foods', '5551000001', 'sales@freshharvestfoods.com', 'Provides fresh fruits and vegetables sourced from regional farms. Offers seasonal produce programs and scheduled deliveries for restaurants.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (3, 'Prime Cut Meats', '5551000002', 'orders@primecutmeats.com', 'Supplies beef, poultry, and pork products for restaurants and catering businesses. Known for consistent quality and custom portioning options.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (4, 'Ocean Crest Seafood', '5551000003', 'service@oceancrestseafood.com', 'Delivers fresh and frozen seafood products. Provides sustainability information and next-day delivery services.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (5, 'Golden Grain Bakery Supply', '5551000004', 'info@goldengrainbakery.com', 'Offers bread, rolls, pastries, and baking ingredients. Supports wholesale restaurant and café accounts.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (6, 'Metro Beverage Distributors', '5551000005', 'support@metrobeverage.com', 'Supplies soft drinks, juices, and specialty beverages. Volume discounts are available for recurring orders.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (7, 'Kitchen Essentials Depot', '5551000006', 'sales@kitchenessentialsdepot.com', 'Provides cookware, utensils, and commercial kitchen tools. Carries products suitable for high-volume restaurant operations.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (8, 'CleanServe Sanitation', '5551000007', 'contact@cleanserve.com', 'Offers cleaning chemicals, paper products, and sanitation supplies. Helps businesses maintain food safety standards.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (9, 'Elite Restaurant Equipment', '5551000008', 'info@eliterestaurantequipment.com', 'Supplies ovens, refrigerators, and commercial kitchen equipment. Installation and maintenance services are available.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (10, 'Farmhouse Dairy Supply', '5551000009', 'orders@farmhousedairy.com', 'Provides milk, cheese, butter, and dairy products. Delivers to restaurants, bakeries, and cafés.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (11, 'Fresh Brew Coffee Co', '5551000010', 'sales@freshbrewcoffee.com', 'Supplies coffee beans, espresso blends, and brewing accessories. Offers training and equipment support.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (12, 'Green Leaf Produce', '5551000011', 'service@greenleafproduce.com', 'Specializes in organic fruits and vegetables. Supports farm-to-table restaurant concepts.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (13, 'Premium Packaging Solutions', '5551000012', 'info@premiumpackaging.com', 'Provides takeout containers, cups, and food packaging materials. Eco-friendly options are available.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (14, 'Superior Ice Supply', '5551000013', 'orders@superiorice.com', 'Delivers bulk ice products for restaurants and events. Flexible delivery schedules are available.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (15, 'Chefs Choice Ingredients', '5551000014', 'support@chefschoiceingredients.com', 'Offers spices, herbs, sauces, and specialty ingredients. Suitable for restaurants seeking unique menu flavors.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (16, 'Valley Poultry Distributors', '5551000015', 'sales@valleypoultry.com', 'Supplies fresh and frozen poultry products. Consistent inventory and food safety compliance.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (17, 'Capital Food Service Supply', '5551000016', 'info@capitalfoodservice.com', 'Provides a wide range of food products and kitchen necessities. Supports restaurants of all sizes.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (18, 'Blue Ribbon Paper Goods', '5551000017', 'contact@blueribbonpaper.com', 'Offers napkins, paper towels, and disposable dining supplies. Bulk pricing available for large orders.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (19, 'Urban Table Furnishings', '5551000018', 'sales@urbantablefurnishings.com', 'Supplies restaurant tables, chairs, and décor items. Custom furnishing options are available.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (20, 'Silver Fork Cutlery Supply', '5551000019', 'orders@silverforksupply.com', 'Provides flatware, serving utensils, and table accessories. Products are designed for commercial durability.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (21, 'Fresh Valley Eggs', '5551000020', 'service@freshvalleyeggs.com', 'Delivers eggs and egg products to restaurants and bakeries. Reliable supply chain and quality control.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (22, 'Rapid Refrigeration Parts', '5551000021', 'support@rapidrefrigeration.com', 'Supplies replacement parts for commercial refrigeration equipment. Fast shipping and technical assistance available.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (23, 'Harvest Specialty Foods', '5551000022', 'info@harvestspecialtyfoods.com', 'Provides gourmet ingredients and imported food products. Ideal for upscale restaurant menus.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (24, 'Crystal Water Services', '5551000023', 'sales@crystalwaterservices.com', 'Offers bottled water and filtration systems. Maintenance programs help ensure consistent water quality.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (25, 'Culinary Uniform Supply', '5551000024', 'contact@culinaryuniforms.com', 'Provides chef coats, aprons, and restaurant uniforms. Embroidery and branding services are available.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (26, 'North Star Frozen Foods', '5551000025', 'orders@northstarfrozenfoods.com', 'Supplies frozen vegetables, meats, and prepared foods. Maintains temperature-controlled logistics.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (27, 'ProTable POS Solutions', '5551000026', 'info@protablepos.com', 'Provides point-of-sale hardware and software systems. Includes installation, training, and support services.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (28, 'Fresh Catch Distribution', '5551000027', 'sales@freshcatchdistribution.com', 'Offers seafood sourcing and delivery services. Focuses on freshness and dependable fulfillment.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (29, 'EcoServe Supplies', '5551000028', 'support@ecoservesupplies.com', 'Provides environmentally friendly cleaning and dining supplies. Helps restaurants reduce waste and improve sustainability.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (30, 'Summit Wholesale Foods', '5551000029', 'contact@summitwholesalefoods.com', 'Distributes bulk food products and pantry staples. Competitive pricing for multi-location restaurant groups.', '2026-06-11', '2026-06-11');
INSERT INTO public."TBL_SUPPLIERS" VALUES (31, 'Master Chef Equipment Supply', '5551000030', 'info@masterchefequipment.com', 'Supplies commercial kitchen equipment and replacement tools. Offers warranty support and preventative maintenance programs.', '2026-06-11', '2026-06-11');


--
-- TOC entry 5057 (class 0 OID 24613)
-- Dependencies: 225
-- Data for Name: TBL_SUPPLIES; Type: TABLE DATA; Schema: public; Owner: serveoAdmin
--

INSERT INTO public."TBL_SUPPLIES" VALUES (1, 1, 'Disposable Gloves', 15, 'Boxes', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (2, 1, 'Disposable Gloves', 15, 'Boxes', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (3, 1, 'Hair Nets', 5, 'Boxes', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (4, 1, 'Aprons', 25, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (5, 1, 'Chef Towels', 10, 'Packs', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (6, 1, 'Dishwashing Detergent', 8, 'Jugs', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (7, 1, 'Sanitizer Solution', 6, 'Jugs', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (8, 1, 'Degreaser Cleaner', 4, 'Jugs', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (9, 1, 'Glass Cleaner', 3, 'Bottles', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (10, 1, 'Floor Cleaner', 4, 'Jugs', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (11, 1, 'Paper Towels', 12, 'Cases', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (12, 1, 'Toilet Paper', 10, 'Cases', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (13, 1, 'Trash Bags (Small)', 6, 'Boxes', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (14, 1, 'Trash Bags (Large)', 8, 'Boxes', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (15, 1, 'Aluminum Foil', 5, 'Rolls', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (16, 1, 'Plastic Wrap', 6, 'Rolls', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (17, 1, 'Parchment Paper', 4, 'Rolls', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (18, 1, 'Food Storage Containers', 20, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (19, 1, 'Food Storage Lids', 20, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (20, 1, 'Takeout Containers', 15, 'Cases', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (21, 1, 'Soup Containers', 8, 'Cases', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (22, 1, 'Disposable Cups', 12, 'Cases', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (23, 1, 'Cup Lids', 12, 'Cases', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (24, 1, 'Plastic Cutlery Sets', 10, 'Cases', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (25, 1, 'Napkins', 20, 'Cases', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (26, 1, 'Order Ticket Rolls', 5, 'Boxes', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (27, 1, 'Receipt Paper Rolls', 8, 'Boxes', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (28, 1, 'Kitchen Sponges', 6, 'Packs', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (29, 1, 'Scrub Pads', 4, 'Packs', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (30, 1, 'Dish Brushes', 10, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (31, 1, 'Mop Heads', 6, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (32, 1, 'Mop Handles', 4, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (33, 1, 'Brooms', 3, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (34, 1, 'Dust Pans', 3, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (35, 1, 'First Aid Kits', 2, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (36, 1, 'Fire Extinguishers', 4, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (37, 1, 'Oven Mitts', 8, 'Pairs', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (38, 1, 'Cut Resistant Gloves', 6, 'Pairs', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (39, 1, 'Chef Knives', 10, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (40, 1, 'Cutting Boards', 12, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (41, 1, 'Sheet Pans', 24, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (42, 1, 'Mixing Bowls', 18, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (43, 1, 'Measuring Cups', 10, 'Sets', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (44, 1, 'Measuring Spoons', 10, 'Sets', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (45, 1, 'Food Thermometers', 8, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (46, 1, 'Label Rolls', 10, 'Rolls', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (47, 1, 'Permanent Markers', 12, 'Boxes', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (48, 1, 'Storage Shelving Units', 4, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (49, 1, 'Cambro Containers', 30, 'Each', '2026-06-12', '2026-06-12');
INSERT INTO public."TBL_SUPPLIES" VALUES (50, 1, 'Wire Racks', 12, 'Each', '2026-06-12', '2026-06-12');


--
-- TOC entry 5052 (class 0 OID 16402)
-- Dependencies: 220
-- Data for Name: TBL_USERS; Type: TABLE DATA; Schema: public; Owner: serveoAdmin
--

INSERT INTO public."TBL_USERS" VALUES (1, 1, 'TEST', 'TEST@TEST.COM', '888888888', '12345', '2026-06-08', '2026-06-08');


--
-- TOC entry 4892 (class 2606 OID 16458)
-- Name: TBL_CUSTOMERS TBL_CUSTOMERS_pkey; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_CUSTOMERS"
    ADD CONSTRAINT "TBL_CUSTOMERS_pkey" PRIMARY KEY ("CUSTOMER_ID");


--
-- TOC entry 4890 (class 2606 OID 16442)
-- Name: TBL_EMPLOYEES TBL_EMPLOYEES_pkey; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_EMPLOYEES"
    ADD CONSTRAINT "TBL_EMPLOYEES_pkey" PRIMARY KEY ("EMPLOYEE_ID");


--
-- TOC entry 4894 (class 2606 OID 24593)
-- Name: TBL_INGREDIENTS TBL_INGREDIENTS_pkey; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_INGREDIENTS"
    ADD CONSTRAINT "TBL_INGREDIENTS_pkey" PRIMARY KEY ("INGREDIENT_ID");


--
-- TOC entry 4880 (class 2606 OID 16401)
-- Name: TBL_ROLES TBL_ROLES_NAME_NAME1_key; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_ROLES"
    ADD CONSTRAINT "TBL_ROLES_NAME_NAME1_key" UNIQUE ("NAME") INCLUDE ("NAME");


--
-- TOC entry 4882 (class 2606 OID 16399)
-- Name: TBL_ROLES TBL_ROLES_pkey; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_ROLES"
    ADD CONSTRAINT "TBL_ROLES_pkey" PRIMARY KEY ("ROLE_ID");


--
-- TOC entry 4896 (class 2606 OID 24607)
-- Name: TBL_SUPPLIERS TBL_SUPPLIERS_pkey; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_SUPPLIERS"
    ADD CONSTRAINT "TBL_SUPPLIERS_pkey" PRIMARY KEY ("SUPPLIER_ID");


--
-- TOC entry 4898 (class 2606 OID 24624)
-- Name: TBL_SUPPLIES TBL_SUPPLIES_pkey; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_SUPPLIES"
    ADD CONSTRAINT "TBL_SUPPLIES_pkey" PRIMARY KEY ("ITEM_ID");


--
-- TOC entry 4884 (class 2606 OID 16427)
-- Name: TBL_USERS TBL_USERS_EMAIL_EMAIL1_key; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_USERS"
    ADD CONSTRAINT "TBL_USERS_EMAIL_EMAIL1_key" UNIQUE ("EMAIL") INCLUDE ("EMAIL");


--
-- TOC entry 4886 (class 2606 OID 16425)
-- Name: TBL_USERS TBL_USERS_USERNAME_USERNAME1_key; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_USERS"
    ADD CONSTRAINT "TBL_USERS_USERNAME_USERNAME1_key" UNIQUE ("USERNAME") INCLUDE ("USERNAME");


--
-- TOC entry 4888 (class 2606 OID 16416)
-- Name: TBL_USERS TBL_USERS_pkey; Type: CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_USERS"
    ADD CONSTRAINT "TBL_USERS_pkey" PRIMARY KEY ("USER_ID");


--
-- TOC entry 4901 (class 2606 OID 16459)
-- Name: TBL_CUSTOMERS TBL_CUSTOMERS_USER_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_CUSTOMERS"
    ADD CONSTRAINT "TBL_CUSTOMERS_USER_ID_fkey" FOREIGN KEY ("USER_ID") REFERENCES public."TBL_USERS"("USER_ID") NOT VALID;


--
-- TOC entry 4900 (class 2606 OID 16443)
-- Name: TBL_EMPLOYEES TBL_EMPLOYEES_USER_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_EMPLOYEES"
    ADD CONSTRAINT "TBL_EMPLOYEES_USER_ID_fkey" FOREIGN KEY ("USER_ID") REFERENCES public."TBL_USERS"("USER_ID");


--
-- TOC entry 4902 (class 2606 OID 24608)
-- Name: TBL_INGREDIENTS TBL_INGREDIENTS_SUPPLIER_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_INGREDIENTS"
    ADD CONSTRAINT "TBL_INGREDIENTS_SUPPLIER_ID_fkey" FOREIGN KEY ("SUPPLIER_ID") REFERENCES public."TBL_SUPPLIERS"("SUPPLIER_ID") NOT VALID;


--
-- TOC entry 4903 (class 2606 OID 24625)
-- Name: TBL_SUPPLIES TBL_SUPPLIES_SUPPLIER_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_SUPPLIES"
    ADD CONSTRAINT "TBL_SUPPLIES_SUPPLIER_ID_fkey" FOREIGN KEY ("SUPPLIER_ID") REFERENCES public."TBL_SUPPLIERS"("SUPPLIER_ID") NOT VALID;


--
-- TOC entry 4899 (class 2606 OID 16419)
-- Name: TBL_USERS TBL_USERS_ROLE_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: serveoAdmin
--

ALTER TABLE ONLY public."TBL_USERS"
    ADD CONSTRAINT "TBL_USERS_ROLE_ID_fkey" FOREIGN KEY ("ROLE_ID") REFERENCES public."TBL_ROLES"("ROLE_ID") NOT VALID;


-- Completed on 2026-06-12 10:07:58

--
-- PostgreSQL database dump complete
--

\unrestrict ssNYmicxjgWVthHtBRbFyypXrIVpUJL9Hh0xYinYjoRP54K6AIY58Skggiwv815

