package service;

import constant.Constantes;
import exception.ReservaException;
import model.Reserva;
import utils.Utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservaService {

    public Integer duracaoEmDias(Reserva reserva) {
        return (int) ChronoUnit.DAYS.between(reserva.getChegada(), reserva.getSaida());
    }

    public void atualizaDatasReserva(Reserva reserva, LocalDate chegada, LocalDate saida) {
        reserva.setChegada(chegada);
        reserva.setSaida(saida);
    }

    public void imprimeReserva(Reserva reserva) {
        StringBuilder dadosReserva = new StringBuilder();
        dadosReserva.append("Quarto: ")
                .append(reserva.getNumeroQuarto())
                .append(", chegada: ")
                .append(Utils.PADRAO_DATA_BRASIL.format(reserva.getChegada()))
                .append(", saída: ")
                .append(Utils.PADRAO_DATA_BRASIL.format(reserva.getSaida()))
                .append(", ")
                .append(duracaoEmDias(reserva))
                .append(" noites.");
        System.out.println(dadosReserva);
    }

    public void validaReserva(Reserva reserva) {
        if (reserva.getChegada() != null && reserva.getChegada().isBefore(LocalDate.now())) {
            throw new ReservaException(Constantes.DATA_CHEGADA_MENOR_DATA_ATUAL);
        }
        if (reserva.getSaida() != null && reserva.getSaida().isBefore(LocalDate.now())) {
            throw new ReservaException(Constantes.DATA_SAIDA_MENOR_DATA_ATUAL);
        }
        if (reserva.getSaida().isBefore(reserva.getChegada())) {
            throw new ReservaException(Constantes.DATA_SAIDA_MENOR_CHEGADA);
        }
    }
}
