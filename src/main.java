import java.util.Scanner;

interface VervoerStrategie {
    void reis();
}

class Auto implements VervoerStrategie {
    public void reis() {
        System.out.println("Je reist met de auto.");
    }
}

class Taxi implements VervoerStrategie {
    public void reis() {
        System.out.println("Je reist met de taxi.");
    }
}

class Bus implements VervoerStrategie {
    public void reis() {
        System.out.println("Je reist met de bus.");
    }
}

class Metro implements VervoerStrategie {
    public void reis() {
        System.out.println("Je reist met de metro.");
    }
}


class Reiziger {
    private VervoerStrategie strategie;

    public void setStrategie(VervoerStrategie strategie) {
        this.strategie = strategie;
    }

    public void uitvoerenReis() {
        if (strategie != null) {
            strategie.reis();
        } else {
            System.out.println("Geen vervoersstrategie gekozen.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reiziger reiziger = new Reiziger();

        System.out.println("Kies een vervoermiddel: auto, taxi, bus of metro:");
        String keuze = scanner.nextLine().toLowerCase();

        switch (keuze) {
            case "auto":
                reiziger.setStrategie(new Auto());
                break;
            case "taxi":
                reiziger.setStrategie(new Taxi());
                break;
            case "bus":
                reiziger.setStrategie(new Bus());
                break;
            case "metro":
                reiziger.setStrategie(new Metro());
                break;
            default:
                System.out.println("Ongeldige keuze.");
                scanner.close();
                return;
        }

        reiziger.uitvoerenReis();
        scanner.close();
    }
}
