package com.kazm.translate.tools;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("dic")
@Repository
public class Dictionary {
	// KOMUNIKATY
	public static final String LOGIN_ERROR = "Nieprawid�owa nazwa u�ytkownika lub has�o!";
	public static final String LOGOUT_SUCCESS = "Wylogowano!";
	public static final String REGISTER_ERROR_LOGIN_USED = "Login zaj�ty.";
	public static final String REGISTER_ERROR_EMAIL_USED = "Adres email zaj�ty.";
	public static final String EDIR_PASS_ERROR = "B��dne obecne has�o";
	public static final String INFO_NEED_TO_CONFIRM_EMAIL = "Konto nale�y aktywowa� za po�rednictwem nades�anego maila.";
	public static final String EMAIL_CONFIRM_MSG = "Adres email potwierdzony.";
	public static final String EMAIL_NOT_CONFIRM_MSG = "B��d podczas potwierdzenia adresu email.";
	public static final String NO_NEW_REF_MSG = "Brak nowych powiadomie�!";
	public static final String NO_SEARCH_RESULT = "Nie znaleziono szukanego tagu.";
	public static final String NO_NEW_RESULT = "Brak notowanych wpis�w.";

	// STATYCZNE
	final String MAIN_TITLE = "Anime-Chronicle";

	final String LOGOUT = "Wyloguj";
	final String LOGIN = "Zaloguj";
	final String PASSWORD = "Has�o";
	final String PASSWORD_REPEAT = "Potwierd� Has�o";
	final String CLEAN = "Wyczy��";
	final String ADMIN = "Admin";
	final String ADD_POST = "Dodaj Post";
	final String WELCOME = "Witaj : ";
	final String USERNAME = "Login";
	final String REASON = "Pow�d";
	final String BAN = "Zbano";
	final String UNBAN = "Odbanuj";
	final String DELETE_PAGE = "Usuwanie Komentarza";
	final String ID = "ID";
	final String REVERS = "Cofnij";
	final String EDIT_USER = "Edytuj U�ytkownika";
	final String EDIT_MOD = "Edytuj moderator�w";
	final String DEL_POST = "Usuni�te posty";
	final String DEL_COMMENT = "Usuni�te komentarze";
	final String BAN_USER = "Zbanowani";
	final String ROLE = "Rola";
	final String MODERATOR = "Moderator";
	final String BANNED_USERS = "Zbanowani";
	final String DELETE = "Usu�";
	final String COMMENT = "Komentuj";
	final String EMAIL = "Email";
	final String REGISTER = "Rejestruj";
	final String USER_PAGE = "Profil U�ytkownika";
	final String SCORE = "Punktacja";
	final String EDIT_PASSWORD = "Zmie� Has�o";
	final String PASSWORD_CURRENT = "Obecne Has�o";
	final String EMAIL_CONFIRM = "Potwierdzenie";
	final String REF = "Powiadomienia";
	final String AUTHOR = "Autor";
	final String LINK = "Odno�nik";
	final String CLEAR_REF = "Wyczy�� Powiadomienia";
	final String NO_USER = "Nie ma takiego u�ytkownika!";
	final String EDIT_POST = "Edytuj Wpis";
	final String EDIT_COMMENT = "Edytuj Komentarz";
	final String EDIT = "Edytuj";
	final String ADD = "Dodaj";
	final String ADD_AVATAR = "Dodaj Avatar";
	final String SELECT_FILE = "Wybierz Plik";
	final String IMAGE_FILE_INFO = "Dozwolone rozszerzenie pliku to *.jpg. Dopuszczalne wymiary: 32x32 px. Maksymalny rozmiar pliku: 100kb";
	final String SEARCH_TITLE = "Znalezione tagi";
	final String ACTIVATE = "Aktywuj";

	final String MSG_LOG_TO_COMMENT = "Zaloguj by komentowa�";
	final String MSG_COMM_DEL = "Komentarz usuni�ty";
	final String MSG_MIN_INPUT = "Minimalna d�ugo�� znak�w";
	final String MSG_EMAIN_NOT_CONFIRMED = "Logowanie wymaga aktywacji konta.";

	public String getSEARCH_TITLE() {
		return SEARCH_TITLE;
	}

	public String getIMAGE_FILE_INFO() {
		return IMAGE_FILE_INFO;
	}

	public String getSELECT_FILE() {
		return SELECT_FILE;
	}

	public String getADD_AVATAR() {
		return ADD_AVATAR;
	}

	public String getADD() {
		return ADD;
	}

	public String getEDIT() {
		return EDIT;
	}

	public String getEDIT_POST() {
		return EDIT_POST;
	}

	public String getEDIT_COMMENT() {
		return EDIT_COMMENT;
	}

	public String getNO_USER() {
		return NO_USER;
	}

	public String getCLEAR_REF() {
		return CLEAR_REF;
	}

	public String getAUTHOR() {
		return AUTHOR;
	}

	public String getLINK() {
		return LINK;
	}

	public String getREF() {
		return REF;
	}

	public String getMSG_EMAIN_NOT_CONFIRMED() {
		return MSG_EMAIN_NOT_CONFIRMED;
	}

	public String getEMAIL_CONFIRM_MSG() {
		return EMAIL_CONFIRM_MSG;
	}

	public String getEMAIL_CONFIRM() {
		return EMAIL_CONFIRM;
	}

	public static String getEdirPassError() {
		return EDIR_PASS_ERROR;
	}

	public String getPASSWORD_CURRENT() {
		return PASSWORD_CURRENT;
	}

	public static String getRegisterErrorLoginUsed() {
		return REGISTER_ERROR_LOGIN_USED;
	}

	public String getEDIT_PASSWORD() {
		return EDIT_PASSWORD;
	}

	public String getMSG_MIN_INPUT() {
		return MSG_MIN_INPUT;
	}

	public String getPASSWORD_REPEAT() {
		return PASSWORD_REPEAT;
	}

	public String getUSER_PAGE() {
		return USER_PAGE;
	}

	public String getSCORE() {
		return SCORE;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public String getCLEAN() {
		return CLEAN;
	}

	public String getROLE() {
		return ROLE;
	}

	public String getMODERATOR() {
		return MODERATOR;
	}

	public String getBANNED_USERS() {
		return BANNED_USERS;
	}

	public String getDELETE() {
		return DELETE;
	}

	public String getCOMMENT() {
		return COMMENT;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public String getREGISTER() {
		return REGISTER;
	}

	public String getMSG_LOG_TO_COMMENT() {
		return MSG_LOG_TO_COMMENT;
	}

	public String getMSG_COMM_DEL() {
		return MSG_COMM_DEL;
	}

	public String getLOGIN() {
		return LOGIN;
	}

	public String getDELETE_PAGE() {
		return DELETE_PAGE;
	}

	public String getID() {
		return ID;
	}

	public String getREVERS() {
		return REVERS;
	}

	public String getEDIT_USER() {
		return EDIT_USER;
	}

	public String getEDIT_MOD() {
		return EDIT_MOD;
	}

	public String getDEL_POST() {
		return DEL_POST;
	}

	public String getDEL_COMMENT() {
		return DEL_COMMENT;
	}

	public String getBAN_USER() {
		return BAN_USER;
	}

	public static String getLoginError() {
		return LOGIN_ERROR;
	}

	public static String getLogoutSuccess() {
		return LOGOUT_SUCCESS;
	}

	public String getMAIN_TITLE() {
		return MAIN_TITLE;
	}

	public String getLOGOUT() {
		return LOGOUT;
	}

	public String getADMIN() {
		return ADMIN;
	}

	public String getADD_POST() {
		return ADD_POST;
	}

	public String getWELCOME() {
		return WELCOME;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public String getREASON() {
		return REASON;
	}

	public String getBAN() {
		return BAN;
	}

	public String getUNBAN() {
		return UNBAN;
	}

	public String getLogout() {
		return LOGOUT;
	}

	public String getACTIVATE() {
		return ACTIVATE;
	}

}