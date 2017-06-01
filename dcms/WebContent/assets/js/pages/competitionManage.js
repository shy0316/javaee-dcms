function del() {
								
								var mes = confirm("您确定要删除此条记录吗？");
								//var del_ = "delete.action?competition.comId=<sa:property value="#session.comId"/>";
								if (mes == true) {
									return true;
								} else {
									return false;
								}
							}