public class App {
    public static void main(String[] args) {
        // a. Registro a los estudiantes
        Estudiante est1 = new Estudiante("LEG-201", "Pedro Pérez");
        Estudiante est2 = new Estudiante("LEG-202", "Sofía Gómez");
        Estudiante est3 = new Estudiante("LEG-203", "Valentino Díaz");

        // b. Construyo los Eventos Universitarios
        EventoUniversitario congreso = new EventoUniversitario("EV-301", "Congreso Tecnológico de Cómputo", 10000.0, false);
        EventoUniversitario tallerLibre = new EventoUniversitario("EV-302", "Jornadas de Software Libre", 0.0, true);

        // c. Asigno una Sala a cada evento
        Sala laboratorio = new Sala(401, "Laboratorio de Sistemas Informáticos");
        Sala auditorio = new Sala(502, "Auditorio René Favaloro");
        congreso.asignarSala(laboratorio);
        tallerLibre.asignarSala(auditorio);

        // d. Creo actividades de tipo Charla y Taller para cada evento
        // Creo una Charla (no requiere notebook, pasamos disertante)
        congreso.crearActividad(1, "Introducción al Desarrollo Web", 30, "Charla", "Ing. Carlos López", false);
        // Creao un Taller de Programación Avanzada que SÍ requiere Notebook (costo $5000)
        congreso.crearActividad(2, "Taller Práctico de Microservicios", 2, "Taller", "", true);

        // Creo una Charla en el evento gratuito
        tallerLibre.crearActividad(3, "La Filosofía del Software Libre", 50, "Charla", "Dr. Richard Stallman", false);

        // e. Inscribo a los estudiantes en las actividades
        // Obtengo el taller práctico de microservicios
        Actividad tallerMicro = congreso.getActividades().get(1);

        System.out.println("INICIANDO PROCESO DE INSCRIPCIONES");
        // Pedro se inscribe
        System.out.println("Anotando a Pedro en el taller: " + tallerMicro.inscribir(est1).getEstado());
        // Sofía se inscribe
        System.out.println("Anotando a Sofía en el taller: " + tallerMicro.inscribir(est2).getEstado());
        // Valentino se quiere inscribir pero el cupo máximo era 2
        System.out.println("Anotando a Valentino en el taller: " + tallerMicro.inscribir(est3).getEstado());


        // Anoto a todos en la charla del congreso
        Actividad charlaWeb = congreso.getActividades().get(0);
        charlaWeb.inscribir(est1);
        charlaWeb.inscribir(est2);
        charlaWeb.inscribir(est3);

        // f. Muestro los datos de cada evento recorriendo las actividades polimórficamente
        System.out.println("RESUMEN DE EVENTOS");
        congreso.mostrarDatos();
        tallerLibre.mostrarDatos();

        // g. Mostramos el total de eventos creados
        System.out.println("Total de eventos registrados en el sistema: " + EventoUniversitario.getCantidadEventos());
    }
}