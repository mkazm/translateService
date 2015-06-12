package com.kazm.translate.tools;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("dic")
@Repository
public class Dictionary {
	// KOMUNIKATY
	public static final String LOGIN_ERROR = "Nieprawid³owa nazwa u¿ytkownika lub has³o!";
	public static final String LOGOUT_SUCCESS = "Wylogowano!";
	public static final String REGISTER_ERROR_LOGIN_USED = "Login zajêty.";
	public static final String REGISTER_ERROR_EMAIL_USED = "Adres email zajêty.";
	public static final String EDIR_PASS_ERROR = "B³êdne obecne has³o";
	public static final String INFO_NEED_TO_CONFIRM_EMAIL = "Konto nale¿y aktywowaæ za poœrednictwem nades³anego maila.";
	public static final String EMAIL_CONFIRM_MSG = "Adres email potwierdzony.";
	public static final String EMAIL_NOT_CONFIRM_MSG = "B³¹d podczas potwierdzenia adresu email.";
	public static final String NO_NEW_REF_MSG = "Brak nowych powiadomieñ!";
	public static final String NO_SEARCH_RESULT = "Nie znaleziono szukanego tagu.";
	public static final String NO_NEW_RESULT = "Brak notowanych wpisów.";

	// ENUMY
	public static final String MAIN_ROLE_CLIENT = "Klient";
	public static final String MAIN_ROLE_TRANSLATOR = "T³umacz";

	// STATYCZNE
	final String MAIN_TITLE = "Anime-Chronicle";

	final String LOGOUT = "Wyloguj";
	final String LOGIN = "Zaloguj";
	final String PASSWORD = "Has³o";
	final String PASSWORD_REPEAT = "PotwierdŸ Has³o";
	final String CLEAN = "Wyczyœæ";
	final String ADMIN = "Admin";
	final String ADD_POST = "Dodaj Post";
	final String WELCOME = "Witaj : ";
	final String USERNAME = "Login";
	final String REASON = "Powód";
	final String BAN = "Zbano";
	final String UNBAN = "Odbanuj";
	final String DELETE_PAGE = "Usuwanie Komentarza";
	final String ID = "ID";
	final String REVERS = "Cofnij";
	final String EDIT_USER = "Edytuj U¿ytkownika";
	final String EDIT_MOD = "Edytuj moderatorów";
	final String DEL_POST = "Usuniête posty";
	final String DEL_COMMENT = "Usuniête komentarze";
	final String BAN_USER = "Zbanowani";
	final String ROLE = "Rola";
	final String MODERATOR = "Moderator";
	final String BANNED_USERS = "Zbanowani";
	final String DELETE = "Usuñ";
	final String COMMENT = "Komentuj";
	final String EMAIL = "Email";
	final String REGISTER = "Rejestruj";
	final String USER_PAGE = "Profil U¿ytkownika";
	final String SCORE = "Punktacja";
	final String EDIT_PASSWORD = "Zmieñ Has³o";
	final String PASSWORD_CURRENT = "Obecne Has³o";
	final String EMAIL_CONFIRM = "Potwierdzenie";
	final String REF = "Powiadomienia";
	final String AUTHOR = "Autor";
	final String LINK = "Odnoœnik";
	final String CLEAR_REF = "Wyczyœæ Powiadomienia";
	final String NO_USER = "Nie ma takiego u¿ytkownika!";
	final String EDIT_POST = "Edytuj Wpis";
	final String EDIT_COMMENT = "Edytuj Komentarz";
	final String EDIT = "Edytuj";
	final String ADD = "Dodaj";
	final String ADD_AVATAR = "Dodaj Avatar";
	final String SELECT_FILE = "Wybierz Plik";
	final String IMAGE_FILE_INFO = "Dozwolone rozszerzenie pliku to *.jpg. Dopuszczalne wymiary: 32x32 px. Maksymalny rozmiar pliku: 100kb";
	final String SEARCH_TITLE = "Znalezione tagi";
	// /////////////////////TRANSLATE
	final String ACTIVATE = "Aktywuj";
	final String ACCOUNT_TYPE = "Typ konta";
	final String ADD_ORDER = "Dodaj zg³oszenie";
	final String DOCUMENT_LANGUAGE = "Jêzyk dokumentu";
	final String TRANSLATION_LANGUAGE = "Jêzyk t³umaczenia";
	final String ORDER_LIST = "Zlecenia";
	final String TRANSLATE = "T³umacz";
	final String STATUS = "Status";
	final String CANCEL = "Rezugnuj";
	final String TRANSLATING = "W T³umaczeniu";
	final String PRICE = "Cena";
	final String DOCUMENT_TYPE = "Typ dokumentu";
	final String BALANCE = "Saldo";
	final String WORD_NUMBER = "Iloœæ s³ów";
	final String CONFIRM = "PotwierdŸ";
	final String DOCUMENT = "Dokument";
	final String TRANSLATION = "T³umaczenie";
	final String FILE = "Plik";
	final String BALANCE_LIST = "Saldo";
	final String DATE = "Data";
	final String OPERATION = "Operacja";

	// ///////////////////////////////TRANSLATE MESSAGE///////////
	public static final String EQUAL_LANGUAGE_WARNING = "Dokumenty nie mog¹ byæ w tych samych jêzykach";
	public static final String TXT_FILE_WARNING = "Plik musi posiadaæ rozszerzenie *.txt";
	public static final String PRICE_ADDED_WARNING = "Cena ju¿ ustalona";
	public static final String PRICE_NOT_ADDED_WARNING = "Aktualnie brak mo¿liwoœci t³umaczenia w podanej kategorii";
	public static final String PRICE_TOO_HIGH = "Brak wystarczaj¹cych œrodków.";

	// ////

	final String MSG_LOG_TO_COMMENT = "Zaloguj by komentowaæ";
	final String MSG_COMM_DEL = "Komentarz usuniêty";
	final String MSG_MIN_INPUT = "Minimalna d³ugoœæ znaków";
	final String MSG_EMAIN_NOT_CONFIRMED = "Logowanie wymaga aktywacji konta.";

	public String getDATE() {
		return DATE;
	}

	public String getOPERATION() {
		return OPERATION;
	}

	public String getBALANCE_LIST() {
		return BALANCE_LIST;
	}

	public String getDOCUMENT() {
		return DOCUMENT;
	}

	public String getTRANSLATION() {
		return TRANSLATION;
	}

	public String getFILE() {
		return FILE;
	}

	public String getCONFIRM() {
		return CONFIRM;
	}

	public String getWORD_NUMBER() {
		return WORD_NUMBER;
	}

	public String getBALANCE() {
		return BALANCE;
	}

	public String getPRICE() {
		return PRICE;
	}

	public String getDOCUMENT_TYPE() {
		return DOCUMENT_TYPE;
	}

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

	public String getMAIN_ROLE_CLIENT() {
		return MAIN_ROLE_CLIENT;
	}

	public String getMAIN_ROLE_TRANSLATOR() {
		return MAIN_ROLE_TRANSLATOR;
	}

	public String getACCOUNT_TYPE() {
		return ACCOUNT_TYPE;
	}

	public String getADD_ORDER() {
		return ADD_ORDER;
	}

	public String getDOCUMENT_LANGUAGE() {
		return DOCUMENT_LANGUAGE;
	}

	public String getTRANSLATION_LANGUAGE() {
		return TRANSLATION_LANGUAGE;
	}

	public String getORDER_LIST() {
		return ORDER_LIST;
	}

	public String getTRANSLATE() {
		return TRANSLATE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public String getCANCEL() {
		return CANCEL;
	}

	public String getTRANSLATING() {
		return TRANSLATING;
	}

}
