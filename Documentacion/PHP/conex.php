<?php
    function conex(){
        $servidor="localhost";
        $usuario="id15717714_root";
        $db="id15717714_softortillabd";
        $contra="A>{Axar4uf^YQIn";
        
        $conexion=mysqli_connect($servidor,$usuario,$contra,$db);
        return $conexion;
    }
?>