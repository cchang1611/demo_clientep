$(window).load(function(){
	 sendMsg(Date.now(), false);
});

try {
    var tabsChannel = new BroadcastChannel("multitabs")
    tabsChannel.onmessage = onMessage
    var userId = Date.now()
} catch(e) {
    error.innerHTML = "BroadcastChannel API not supported in this device."
    error.classList.remove("close")
}

function onMessage(e) { 
	console.log(e);
	console.log(e.data.unload);
	windowUpdated(false);
}

function sendMsg(userId, unloading) {
	tabsChannel.postMessage({id:userId,unload:unloading})
}

function windowUpdated(mainWindow) {
	
	if (mainWindow != true) {
		
		$("body *").css("pointer-events","none");
		$("#mensajeErrorTabModal").text("Detectamos que el sitio esta abierto en otra pestaña, por favor continua en la otra pestaña.");
		$("#errorTabModalHeader").empty();
		$("#errorTabModal").css("opacity", "1");
		console.log("pestana duplicada");
	}else{
		$("#errorTabModal").css("opacity", "0");
		console.log("se cerro la pestana duplicada");
		
	}
	
}

