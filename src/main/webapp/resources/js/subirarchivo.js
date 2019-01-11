/**
 * 
 */

$(document ).ready(function() {	
	$("#divFormulario").show();$("#divTblOutput").hide();	

	$(".alert").hide();	
	$('#idSolicitud').val("");
	$('.aLink').attr('href','#');
	
	var table= $('#tblOutput').DataTable( {
    	"bJQueryUI":true,
        "processing": true,
        "responsive": true,
        "bSort":false,
        "bPaginate":false,
        //"scrollCollapse": true,
        //"scrollY":        "300px",
        "dom": '<"row" <"col-sm-12" t> ><"row" <"col-sm-3"l> <"col-sm-4"i> <"col-sm-5"p>>',
        "iDisplayLength": 10,
        "sPaginationType" : 'full_numbers',
        "ajax": {
            "url": './mostrarSalida',
            "type":'GET',
            "data": function (d) {
            	console.log("llamadaAjax"); 
                d.filtroIdSolicitud = $('#idSolicitud').val();
            }
          },
        "serverSide": true,
        "columns": [
            { "data": "tipoDocumento" },
            { "data": "documento" },
            { "data": "apePaterno",render: function (data, type, row ) {            		
                return row.apePaterno +" "+row.apeMaterno+" "+row.primerNombre +" "+row.segundoNombre;
            } },
            { "data": "numCelular1" },
            { "data": "numTelefono" },
            { "data": "email1" },
            { "data": "direccion" },
            { "data": "distrito" },
            { "data": "provincia" },
            { "data": "departamento" },          
            { "data": "flgLpd" }
        ],
        "select": true
    } );
	

	
	$('#procesar').click(function(){	
		console.log("procesar1"); 

        
        var form = $('#fileUploadForm')[0];

        var data = new FormData(form);

        //stop submit the form, we will post it manually.
        event.preventDefault();

        // Get form
        var form = $('#fileUploadForm')[0];

		// Create an FormData object 
        var data = new FormData(form);
        
        if(data.get("file").name.length>0){
    		// If you want to add an extra field for the FormData
            //data.append("CustomField", "This is some extra data, testing");
    		// disabled the submit button
        	        		 
			swal({   
				title: "Procesando",   
				text: "Espere. "    ,	
				showLoaderOnConfirm: true ,
				showConfirmButton: false
			});
//        	
        	$("#procesar").prop("disabled", true);
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "/upload",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {  
                	 swal.close();
                	if(data.estado){
                        console.log("SUCCESS : ", data);
                        $("#procesar").prop("disabled", false);
                    	//data.values.idSolicitud="B28219201812271823";
                        $('#idSolicitud').val(data.values.idSolicitud);
                        table.ajax.reload();
                        $('#idTituloGrilla').text("SOLICITUD: "+data.values.idSolicitud);
                        $('.aLink').attr('href','/download/output.xlsx?idSolicitud='+data.values.idSolicitud);                    
                        $("#divFormulario").hide();$("#divTblOutput").show();
                	}else{                  
                       
                        $("#procesar").prop("disabled", false);
                        
                        Command: toastr["error"](data.mensaje, "RAWR")

                        toastr.options = {
                          "closeButton": false,
                          "debug": false,
                          "newestOnTop": false,
                          "progressBar": false,
                          "rtl": false,
                          "positionClass": "toast-top-right",
                          "preventDuplicates": false,
                          "onclick": null,
                          "showDuration": 300,
                          "hideDuration": 1000,
                          "timeOut": 5000,
                          "extendedTimeOut": 1000,
                          "showEasing": "swing",
                          "hideEasing": "linear",
                          "showMethod": "fadeIn",
                          "hideMethod": "fadeOut"
                        }  
                	}

                },
                error: function (e) {
                    console.log("ERROR : ", e);
                    swal.close();
                    $("#procesar").prop("disabled", false);
                    $('#idTituloGrilla').text("ERROR AL CARGAR DATA");
                    
                    Command: toastr["error"](e, "Gobierno de Datos - Interbank")

                    toastr.options = {
                      "closeButton": false,
                      "debug": false,
                      "newestOnTop": false,
                      "progressBar": false,
                      "rtl": false,
                      "positionClass": "toast-top-right",
                      "preventDuplicates": false,
                      "onclick": null,
                      "showDuration": 300,
                      "hideDuration": 1000,
                      "timeOut": 5000,
                      "extendedTimeOut": 1000,
                      "showEasing": "swing",
                      "hideEasing": "linear",
                      "showMethod": "fadeIn",
                      "hideMethod": "fadeOut"
                    }                    
                }
            });
        }else{
            Command: toastr["warning"]("Gobierno de Datos - Interbank", "Sube un archivo .TXT")

    		toastr.options = {
    		  "closeButton": false,
    		  "debug": false,
    		  "newestOnTop": false,
    		  "progressBar": true,
    		  "rtl": false,
    		  "positionClass": "toast-top-right",
    		  "preventDuplicates": false,
    		  "onclick": null,
    		  "showDuration": 300,
    		  "hideDuration": 1000,
    		  "timeOut": 50000,
    		  "extendedTimeOut": 1000,
    		  "showEasing": "swing",
    		  "hideEasing": "linear",
    		  "showMethod": "fadeIn",
    		  "hideMethod": "fadeOut"
    		}
        } 	
        
	});	
	
})