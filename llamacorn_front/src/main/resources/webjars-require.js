/*global requirejs*/

//Ensure any request for this webjar brings in jquery.

requirejs.config({
	paths:{
		"bootstrap": webjars.path("bootstratp","js/bootstrap"),
		"bootstrap-css": webjars.path("bootstrap","css/bootstrap")
	},
	shim:{"bootstrap":["jquery"]}
});