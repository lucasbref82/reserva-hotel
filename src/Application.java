import exception.ReservaException;
import model.Reserva;
import service.ReservaService;
import utils.Utils;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Número do quarto: ");
            Integer numeroQuarto = scanner.nextInt();
            System.out.print("Data de chegada (DD/MM/YYYY): ");
            LocalDate chegada = LocalDate.parse(scanner.next(), Utils.PADRAO_DATA_BRASIL);
            System.out.print("Data de saída (DD/MM/YYYY): ");
            LocalDate saida = LocalDate.parse(scanner.next(), Utils.PADRAO_DATA_BRASIL);
            Reserva reserva = new Reserva(numeroQuarto, chegada, saida);
            ReservaService reservaService = new ReservaService();
            reservaService.validaReserva(reserva);
            reservaService.imprimeReserva(reserva);
            System.out.println();
            System.out.println("Digite os dados para atualização da reserva");
            System.out.print("Data de chegada: ");
            chegada = LocalDate.parse(scanner.next(), Utils.PADRAO_DATA_BRASIL);
            System.out.print("Data de saída: ");
            saida = LocalDate.parse(scanner.next(), Utils.PADRAO_DATA_BRASIL);
            reservaService.validaReserva(reserva);
            reservaService.atualizaDatasReserva(reserva, chegada, saida);
            reservaService.imprimeReserva(reserva);
        } catch (ReservaException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro inesperado !");
        } finally {
            scanner.close();
        }
    }
}