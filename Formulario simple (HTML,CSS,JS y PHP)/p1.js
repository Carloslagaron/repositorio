function enviarFormulario() {

var password = document.getElementById('password').value;
var telefono = document.getElementById('telefono').value;
var mayus = /[A-Z]/;
var minus = /[a-z]/;
var nums = /[0-9]/;
var simb = /[*/+-]/;
	console.log('Enviando formulario...');
	
	if (password.length != "") {

		if(password.length < 6 || password.length > 12) {
			alert("Contraseña incorrecta: la longitud debe de ser entre 6-12 caracteres");
			return false;
		}
	
		if(password.match(mayus)) {
		} else {
			alert("Contraseña incorrecta: debe contener al menos una mayúscula");
			return false;
		}
	
		if(password.match(minus)) {
		} else {
			alert("Contraseña incorrecta: debe contener al menos una minúscula");
			return false;
		}
	
		if(password.match(nums)) {
		} else {
			alert("Contraseña incorrecta: debe contener al menos un número");
			return false;
		}
	
		if(password.match(simb)) {
		} else {
			alert("Contraseña incorrecta: debe contener al menos uno de estos símbolos: + - / *");
			return false;
		}
	}

	if((telefono.length != 9) && telefono.length != "") {
		alert("Teléfono incorrecto: la longitud debe de ser de 9 caracteres");

	return false;
	}
	
	if((telefono.charAt(0) != "6" && telefono.charAt(0) != "7" && telefono.charAt(0) != "8" && telefono.charAt(0) != "9") && telefono.length != "") {
		alert("Teléfono incorrecto: debe empezar por cualquiera de los siguiente números: 9,8,7 o 6");
		return false;
	}

	var navegador = "";
	navegador += navigator.appCodeName;
	document.getElementById("navegador").setAttribute("value",navegador);
	
}

function marcarTodos() {
	for (i=0;i<document.f.elements.length;i++) {
      if(document.f.elements[i].type == "checkbox")
         document.f.elements[i].checked= 1;
	}
       }

function desmarcarTodos() {
	for (i=0;i<document.f.elements.length;i++) {
      if(document.f.elements[i].type == "checkbox") 
         document.f.elements[i].checked= 0;
	}
       }


function metodoGet() {
	document.getElementById("formulario").setAttribute("method","GET");
	if (document.getElementById("multi").checked) {
		alert("El método de codificación multipart no es compatible con el método de envío GET");		
		document.getElementById("bpost").checked = true;
	}
}

function metodoPost() {
	document.getElementById("formulario").setAttribute("method","POST");
	}


function metodoMultipart(){
    	document.getElementById("formulario").setAttribute("enctype","multipart/form-data");
        if (document.getElementById("bget").checked) {
             alert("El método de codificación multipart no es compatible con el método de envío GET");
            document.getElementById("bapli").checked=true;
        }
}

function metodoAplication(){

    document.getElementById("formulario").setAttribute("enctype","application/x-www-form-urlencoded");
}