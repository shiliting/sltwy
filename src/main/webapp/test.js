//(function(a,b){alert("jquery");}(c,function(){alert("back");}));


var editPage = {};


editPage.init = function () {
   console.log("init");
};

editPage.init();

$(document).on('content-changed', function (event, row) {
   console.log(this);
   console.log(event);
   console.log(row);
   $("h2").hide();
});