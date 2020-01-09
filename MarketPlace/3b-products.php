<?php
/* [INIT - GET PRODUCTS] */
require __DIR__ . DIRECTORY_SEPARATOR . "lib" . DIRECTORY_SEPARATOR . "2a-config.php";
require PATH_LIB . "2b-lib-db.php";
require PATH_LIB . "3a-lib-products.php";
$pdtLib = new Products();
$products = $pdtLib->get();

/* [HTML] */ ?>
<!DOCTYPE html>
<html>
  <head>
    <title>
      Simple Cart Demo
    </title>
    <link rel="stylesheet" type="text/css" href="public/3c-theme.css">
    <script src="public/4a-cart.js"></script>
  </head>
  <body>

    <img src="images/gm.png" style="width:50px;height: 50px;">
    <p style="font-size: 38px;margin-left: 50px;margin-top: -50px;font-family: Verdana;">GreenMarket</p>
    <ul>
    <li><a href="http://localhost:8080/Green_Market_Updated/Profile.html">Profile</a></li>
  <li><a href="http://localhost:8080/Green_Market_Updated/Reaction.html">Reaction</a></li>
  <li><a href="http://localhost:80/1/3b-products.php">Market Place</a></li>
  <li><a href="http://localhost:80/1/3b-products.php">Cart</a></li>
  <li><a href="#about">About Us</a></li>
    </ul>
      <!-- [CART BUTTON] -->
      <div id="page-cart-icon" onclick="cart.toggle();">
        &#128722; <span id="page-cart-count">0</span>
      </div>
    </header>

    <!-- [PRODUCTS] -->	
    <div id="page-products"><?php
      if (is_array($products)) {
        foreach ($products as $id => $row) { ?>
          <div class="pdt">
            <img class="pdt-img" src="images/<?= $row['product_image'] ?>"/>
            <h3 class="pdt-name"><?= $row['product_name'] ?></h3>
            <div class="pdt-price">$<?= $row['product_price'] ?></div>
            <div class="pdt-desc"><?= $row['product_description'] ?></div>
            <input class="pdt-add" type="button" value="Add to cart" onclick="cart.add(<?= $row['product_id'] ?>);"/>
          </div>
        <?php }
      } else {
        echo "No products found.";
      }
      ?></div>

    <!-- [CART] -->
    <div id="page-cart" class="ninja"></div>
  </body>
</html>