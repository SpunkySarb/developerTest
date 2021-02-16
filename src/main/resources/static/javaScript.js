$(document).ready(function(){


$(".addContact, .newContact").click(function(){

$(".addContactWindow").fadeIn(300);



});



$(".addCancel").click(function(){

  $(".addContactWindow").fadeOut(300);






});



$(".addInformation").click(function(){
  $(".addInformation > span").text("");

  $(".addInformation > span").attr("class", "fa fa-spinner w3-spin w3-large");






});

$(document).scroll(function(){
  if($(document).scrollTop()>50){

  $(".heading").slideUp(500);

} else if ($(document).scrollTop()<50) {
  $(".heading").slideDown(500);

}

});

$(".menu").click(function(){


$(".sidebar").show(200);


});

$(".closeSidebar").click(function(){


$(".sidebar").hide(200);


});










});
