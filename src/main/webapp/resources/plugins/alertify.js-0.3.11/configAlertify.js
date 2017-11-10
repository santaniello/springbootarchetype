function reset (labelOK) {
	if(labelOK == undefined) labelOK = "OK";
	alertify.set({
		labels : {
			ok     : labelOK,
			cancel : "Cancelar"
		},
		delay : 10000,
		buttonReverse : false,
		buttonFocus   : "cancel"
	});
}
