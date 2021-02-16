<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>DEV TEST</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="style.css">
  </head>
  <body >












<div class="w3-bar w3-card-4 w3-black w3-jumbo w3-top heading">
  <div class=" menu w3-bar-item w3-button w3-ripple w3-left w3-hover-black fa fa-bars">

  </div>
  <div class="w3-bar-item  w3-center  ">
<h3>Address Book</h3>
</div>

<div class="w3-bar-item w3-button w3-hover-black w3-right w3-xxlarge w3-center">
<h3 class="fa fa-search"></h3>
</div>
</div>
<!--Sidebar here -->

<div class="w3-sidebar sidebar w3-black" style="display:none;">

<div class="w3-display-container">
  <h3 class=" w3-border-gray">Actions</h3>
  <span class="w3-display-topright closeSidebar w3-gray w3-button">X</span>
</div>
<div class="w3-container w3-center w3-black">

  <div class="w3-border  w3-large">

    <p> Shared to me</p>
  </div>
  <div class="w3-border newContact  w3-large">

    <p> Add Contact</p>
  </div>

  <div class="w3-border w3-large">

    <p> About</p>
  </div>
  <div class="w3-border w3-large">

    <p> Log out</p>
  </div>

<div class="w3-panel w3-gray w3-border-yellow w3-leftbar w3-card" id="logout">
<p>Developed by Sarb</p>
</div>

</div>
</div>

<!--add contact -->
<div class="w3-xlarge w3-button w3-circle w3-black w3-card-4 w3-border addContact">
  +
</div>



<br>
<!-- contact list -->
<br><br><br><br>


${contactCode}





<!-- contact list ends here -->

<!-- add contact modal -->

<div class="w3-modal w3-black  addContactWindow">

<div class="w3-modal-content w3-round-large w3-gray">

<div class="w3-container w3-margin w3-gray"><br>
<div class="w3-container w3-round-large w3-center w3-black">
  <h3>Add New Contact</h3>
</div>

<div class="w3-container w3-margin">
  <form class="" name="addContact"  action="addContact" method="post">


<input type="file" class="w3-round w3-black" name="image" value="" style="width:200px;"> <br><br>
<input type="text" class="w3-input w3-round-large" name="firstName"  value="" placeholder="Enter First Name.."><br>
<input type="text" class="w3-input w3-round-large" name="lastName"  value="" placeholder="Enter Last Name.."><br>
<input type="text" class="w3-input w3-round-large" name="phoneNumber"  value="" placeholder="Enter Phone Number.."><br>
<input type="text" class="w3-input w3-round-large" name="email"  value="" placeholder="Enter Email Id.."><br>
<br>
<button  type="submit" class="w3-button w3-black addInformation" name="button"><span>ADD</span></button>
<button type="button"  class="w3-button w3-black addCancel" name="button">CANCEL</button>

</form>
</div>



</div>





</div>


</div> <!-- Modal Ends here -->















<script src="javaScript.js" charset="utf-8"></script>
  </body>
</html>
