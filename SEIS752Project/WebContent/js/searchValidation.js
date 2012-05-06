/**
 * This file contains the javascript validation script for the search page
 */
$(function() {						
	
		$("#keyword").focus();
		$('#div_param').hide();
						
		$('#clickAdvanced').click(function(){
			$('#div_param').show();
			$('#clickAdvanced').hide();
			$('#grade_chzn').hide();
			$('#subject_chzn').hide();
		});
								
		$("#search-form-main-a").click(function() { 					  						
			
			if (($('#keyword').val() == '' || $('#keyword').val() == 'Type Keyword Here') && ($('#search_param1').val() == '')){
				alert("Please enter keyword...");
				return false;
			}
			
			if (($('#keyword').val() != '' || $('#keyword').val() != 'Type Keyword Here') && ($('#search_param1').val() == '')){										
				window.location.href = "search.do?keyword="+ $('#keyword').val();																
			}
			
			if (($('#keyword').val() == '' || $('#keyword').val() == 'Type Keyword Here') && ($('#search_param1').val() != '')){										
				alert("Please enter Keyword...");
				return false;																
			}
			
			if (($('#keyword').val() != '' || $('#keyword').val() != 'Type Keyword Here') && ($('#search_param1').val() != '')){								
				if ($('#search_param1').val() == 'description'){
					window.location.href = "search.do?param="+$('#search_param1').val()+"&keyword="+ $('#keyword').val();
				}else if ($('#search_param1').val() == 'grade'){
					window.location.href = "search.do?param="+$('#search_param1').val()+"&grade="+$('#grade').val()+"&keyword="+ $('#keyword').val();
				}else if ($('#search_param1').val() == 'subject'){
					window.location.href = "search.do?param="+$('#search_param1').val()+"&subject="+$('#subject').val()+"&keyword="+ $('#keyword').val();
				}else{
					window.location.href = "search.do?keyword="+ $('#keyword').val();	
				}
					
			}
			return false;			
		});
		
		//Data manipulation						
		$('#search_param1').change(function(){			
			if (($('#search_param1').val() == '') || ($('#search_param1').val() == 'description')){
				$('#grade_chzn').hide();
				$('#subject_chzn').hide();	
			}
			if ($('#search_param1').val() == 'grade'){
				$('#grade_chzn').show();
				$('#subject_chzn').hide();	
			}
			if ($('#search_param1').val() == 'subject'){
				$('#grade_chzn').hide();
				$('#subject_chzn').show();	
			}
		});		
					
		
	});	