<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $json=array();
    
        if(isset($_GET["IdAlmacen"])){
            $IdProducto=$_GET["IdAlmacen"];
            
            $consulta="select * from Almacen where IdAlmacen= '{$IdAlmacen}'";
            $resultado=mysqli_query($conexion, $consulta);
            
            if($registro=mysqli_fetch_array($resultado)){
                $json['Almacen'][]=$registro;
                
            }else{
                $resultar["nombre"]='no registra';
                $resultar["descripcion"]='no registra';
                $resultar["cantidad"]='no registra';
                $resultar["categoria"]='no registra';
                $json['Almacen'][]=$resultar;
            }
            
            mysqli_close($conexion);
            echo json_encode($json);
            
        }else{
            $resultar["succes"]=0;
            $resultar["message"]='Web service no Retorna';
            $json['Almacen'][]=$resultar;
            echo json_encode($json);
        }
?>