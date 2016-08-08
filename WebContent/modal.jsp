<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Modal</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container" style="margin-top: 60px">
			<button class="btn btn-info" data-toggle="modal" data-target="#miventana">
				Abrir ventana
			</button>
			
			<div class="modal fade" id="miventana" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
					
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
					
					</div>
				</div>
			</div>
		</div>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	</body>
</html>