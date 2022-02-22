<?php

    //include 'conex.php';
    require_once "conex.php";
    $conexion=conex();
    
    $IdAlmacen=$_GET['IdAlmacen'];
    
    $consulta = "select * from Almacen where IdAlmacen= '$IdAlmacen'";
    $resultado= $conexion -> query($consulta);
    
    while($fila=$resultado -> fetch_array()){
        $Almacen[] = array_map('utf8_encode', $fila);
    }
    
    echo json_encode($Almacen);
    $resultado -> close();
    
    ?>