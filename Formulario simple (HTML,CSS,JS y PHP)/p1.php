<!DOCTYPE html>
<html lang="es">
<body>
	<section class = "registro">
	<?php
	
	echo "<link rel= stylesheet href= p1.css>";

	if ($_POST) {

		echo "Nombre: " .$_POST["cname"]."<br>";
		echo "Usuario: " .$_POST["clogin"]."<br>";
		echo "Contraseña: " .$_POST["cpasswd"]."<br>";
		echo "Teléfono: " .$_POST["ctlph"]."<br>";
		echo "Correo: " .$_POST["cemail"]."<br>";
		
		if(!empty($_POST["cage"])){
			echo "Edad: " .$_POST["cage"]."<br>";
		} else {
			echo "Edad: "."<br>";
		}

		if(!empty($_POST["cgenre"])){
			echo "Generos: ";
		foreach ($_POST["cgenre"] as $selected) {
			echo $selected. " ";
			}
		} else {
			echo "Géneros: ";
		}
		
		echo "<br>Comentario: " .$_POST["ccomment"]."<br>";
		echo "Compañía: " .$_POST["cInternet"]."<br>";
		echo "Método de envío: " .$_POST["cage2"]."<br>";
		echo "Tipo de codificación: " .$_POST["cage3"]."<br>";
		echo "Navegador: " .$_POST["cbrowser"]."<br>";
		echo "IP: [ " . $_SERVER["SERVER_ADDR"] . " ]</br>";

		} else {
		echo "Nombre: " .$_GET["cname"]."<br>";
		echo "Usuario: " .$_GET["clogin"]."<br>";
		echo "Contraseña: " .$_GET["cpasswd"]."<br>";
		echo "Teléfono: " .$_GET["ctlph"]."<br>";
		echo "Correo: " .$_GET["cemail"]."<br>";
		
		if(!empty($_GET["cage"])){
			echo "Edad: " .$_GET["cage"]."<br>";
		} else {
			echo "Edad: "."<br>";
		}




		if(!empty($_GET["cgenre"])){
			echo "Generos: ";
			foreach ($_GET["cgenre"] as $selected) {
				echo $selected. " ";
			}
		} else {
			echo "Géneros: ";
		}
		
		echo "<br>Comentario: " .$_GET["ccomment"]."<br>";
		echo "Compañía: " .$_GET["cInternet"]."<br>";
		echo "Método de envío: " .$_GET["cage2"]."<br>";
		echo "Tipo de codificación: " .$_GET["cage3"]."<br>";
		echo "Navegador: " .$_GET["cbrowser"]."<br>";
		echo "IP: [ " . $_SERVER["SERVER_ADDR"] . " ]</br>";
		

		
		
	}



	?>
	
</section>
	
	<?php echo htmlspecialchars($_REQUEST[phpinfo()]) ?></td>
</body>
</html>
