module JavaFXApp {
	 	requires javafx.controls;
	    requires javafx.fxml;
	    requires java.sql;

	    exports program;
	    exports frontEnd;
	    exports menus;
	    exports criptografia;
	    exports DAO;
	    exports connection;
	    exports entities;
	    exports utils;
	    exports SGBD_X;
}
