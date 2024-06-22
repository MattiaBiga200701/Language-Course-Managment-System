package controller;

import model.domain.Credentials;

public class ApplicationController implements Controller {

    Credentials cred;

    @Override
    public void start() {
        LoginController loginController = new LoginController();
        loginController.start();
        cred = loginController.getCred();

        if(cred.getRole() == null) {
            throw new RuntimeException("Invalid credentials");
        }

        switch(cred.getRole()) {
            case AMMINISTRAZIONE -> new AmministrazioneController().start();
            case SEGRETERIA -> new SegreteriaController().start();
            case INSEGNANTE -> System.out.println("Logged as Insegnante");
            default -> throw new RuntimeException("Invalid credentials");
        }
    }

}

