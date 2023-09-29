const BotonCrear = document.getElementById('crearBoton');
            let conForm= document.getElementById('formCrear');
            let BotonSalir = document.getElementById('salir');
            BotonCrear.addEventListener('click', function(){
                    conForm.style.display = 'flex';

                    BotonSalir.addEventListener('click', function(){
                    conForm.style.display = 'none';
                    }); 
                });   