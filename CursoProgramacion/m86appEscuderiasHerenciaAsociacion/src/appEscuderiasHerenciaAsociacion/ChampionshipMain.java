package appEscuderiasHerenciaAsociacion;

import java.util.*;

import javax.swing.JOptionPane;

public class ChampionshipMain {

	static ArrayList<Team> teams = new ArrayList<Team>();

	public static void main(String[] args) {
		String championship = "", pilotStr = "", mechanicStr = "", teamStr = "";
		Object[] choice = new Object[0];
		Team.loadData(teams);
		do {
			choice = new Object[] { "Salir de la aplicación", "Pilotos", "Mecánicos", "Escuderías", "Coches" };
			championship = Dialogo.seleccionar(choice, "Campeonato", "Menú Principal", 0);

			switch (championship) {
			case "Salir de la aplicación":
				JOptionPane.showMessageDialog(null, "Gracias por su visita");
				break;
			case "Pilotos":
				do {
					choice = new Object[] { "Volver al menú principal", "Crear Piloto", "Ver Piloto",
							"Dar de baja al Piloto" };
					pilotStr = Dialogo.seleccionar(choice, "Gestión Pilotos", "Menú", 0);
					switch (pilotStr) {
					case "Volver al menú principal":
						JOptionPane.showMessageDialog(null, "Vuelve al Menú Principal");
						break;
					case "Crear Piloto":
						createPilot(teams);

						break;
					case "Ver Piloto":
						showPilots(teams);

						break;
					case "Dar de baja al Piloto":
						findRemovePilot(teams);
						break;
					}

				} while (!"Volver al menú principal".equalsIgnoreCase(pilotStr));

				break;
			case "Mecánicos":
				do {
					choice = new Object[] { "Volver al menú principal", "Crear Mecánico", "Ver Mecánico",
							"Dar de baja al Mecánico" };
					mechanicStr = Dialogo.seleccionar(choice, "Gestión Mecánicos", "Menú", 0);
					switch (mechanicStr) {
					case "Volver al menú principal":
						JOptionPane.showMessageDialog(null, "Vuelve al Menú Principal");
						break;
					case "Crear Mecánico":
						createMechanic(teams);
						break;
					case "Ver Mecánico":
						showMechanics(teams);
						break;
					case "Dar de baja al Mecánico":
						findRemoveMechanic(teams);
						break;
					}

				} while (!"Volver al menú principal".equalsIgnoreCase(mechanicStr));

				break;
			case "Escuderías":
				do {
					choice = new Object[] { "Volver al menú principal", "Ver Escuderías participantes",
							"Ver datos de una escudería" };
					teamStr = Dialogo.seleccionar(choice, "Gestión Escuderías", "Menú", 0);
					switch (teamStr) {
					case "Volver al menú principal":
						JOptionPane.showMessageDialog(null, "Vuelve al Menú Principal");
						break;
					case "Ver Escuderías participantes":// Arreglado con Mostrar y toString (tostring automático, el
						String message = Team.showTeamName(teams); // resto métodos con bucle)
						JOptionPane.showMessageDialog(null, message);
						break;
					case "Ver datos de una escudería":
						showTeams();// si abajo no ponemos ArrayList<Team>teams, aquí no ponemos showTeam(teams);
						break;
					}
				} while (!"Volver al menú principal".equalsIgnoreCase(teamStr));

			case "Coches":
				do {
					choice = new Object[] { "Volver al menú principal", "Ver coches de una escudería" };
					teamStr = Dialogo.seleccionar(choice, "Gestión Monoplazas", "Menú", 0);
					switch (teamStr) {
					case "Volver al menú principal":
						JOptionPane.showMessageDialog(null, "Vuelve al Menú Principal");
						break;
					case "Ver coches de una escudería":// Arreglado con Mostrar y toString (tostring automático, el
						showCars(teams);
						break;
					}
				} while (!"Volver al menú principal".equalsIgnoreCase(teamStr));

				break;
			}
		} while (!"Salir de la aplicación".equalsIgnoreCase(championship));

	}

	public static void createPilot(ArrayList<Team> teams) {
		String check = "", dni = "", name = "", surname = "";
		int position = 0, dniPositionP = 0, dniPositionM, age = 0, experienceTeam = 0;
		double height = 0, weight = 0;
		Team teamRace;
		check = JOptionPane.showInputDialog("Introduzca la escudería");
		position = findTeam(teams, check);
		if (position != -1) {
			teamRace = teams.get(position);
			dni = JOptionPane.showInputDialog("Introduzca su DNI o equivalente");
			dniPositionP = findDuplicatePilot(teams, dni);
			dniPositionM = findDuplicateMechanic(teams, dni);
			if (dniPositionP != -1) {
				JOptionPane.showMessageDialog(null, "El piloto ya existe en alguna escudería");
			} else if (dniPositionP == -1) {
				dniPositionM = findDuplicateMechanic(teams, dni);
				if (dniPositionM == -1) {
					name = JOptionPane.showInputDialog("Nombre");
					surname = JOptionPane.showInputDialog("Apellido");
					age = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
					experienceTeam = Integer.parseInt(JOptionPane.showInputDialog("Años en la escudería"));
					height = Double.parseDouble(JOptionPane.showInputDialog("Altura, preferiblemente en centímetros"));
					weight = Double.parseDouble(JOptionPane.showInputDialog("Peso en kilos"));
					teamRace.addPilot(name, surname, dni, age, experienceTeam, height, weight);
				} else {
					JOptionPane.showMessageDialog(null, "El piloto ya existe pero como Mecánico en alguna escudería");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "La escudería no existe");
		}

	}

	public static void createMechanic(ArrayList<Team> teams) {
		String check = "", dni = "", name = "", surname = "";
		int position = 0, dniPositionP = 0, dniPositionM, age = 0, experienceTeam = 0;
		boolean studiesSup = false;
		Team teamRace;
		check = JOptionPane.showInputDialog("Introduzca la escudería");
		position = findTeam(teams, check);
		if (position != -1) {
			teamRace = teams.get(position);
			dni = JOptionPane.showInputDialog("Introduzca su DNI o equivalente");
			dniPositionP = findDuplicatePilot(teams, dni);
			dniPositionM = findDuplicateMechanic(teams, dni);
			if (dniPositionM != -1) {
				JOptionPane.showMessageDialog(null, "El mecánico ya existe en alguna escudería" + teamRace.toString());
			} else if (dniPositionM == -1) {
				dniPositionP = findDuplicatePilot(teams, dni);
				if (dniPositionP == -1) {
					name = JOptionPane.showInputDialog("Nombre");
					surname = JOptionPane.showInputDialog("Apellido");
					age = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
					experienceTeam = Integer.parseInt(JOptionPane.showInputDialog("Años en la escudería"));
					studiesSup = Boolean.parseBoolean(JOptionPane.showInputDialog("Estudios superiores"));
					teamRace.addMechanic(name, surname, dni, age, experienceTeam, studiesSup);
				} else {
					JOptionPane.showMessageDialog(null,
							"El mecánico, existe como piloto en la escudería" + teamRace.toString());
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "La escudería no existe");
		}

	}

	public static void showPilots(ArrayList<Team> teams) {
		String teamName = "", teamPilots = "";
		int position = 0, i = 0, sizePilots = 0;
		Team team;
		teamName = JOptionPane.showInputDialog("Introduce el nombre de la escudería");
		position = findTeam(teams, teamName);
		if (position != -1) {
			team = teams.get(position);
			teamPilots = "Pilotos de " + team.getName() + "\n";
			sizePilots = team.getPilots().size();
			while (i < sizePilots) {
				Pilot pilot = team.getPilots().get(i);
				teamPilots += pilot + "\n";
				i++;
			}
			if (team.getPilots().size() == 0) {
				teamPilots = "No hay pilotos en esta escudería";
			}
			JOptionPane.showMessageDialog(null, teamPilots);
		} else {
			JOptionPane.showMessageDialog(null, "Error al introducir la escudería");
		}
	}

	public static void showMechanics(ArrayList<Team> teams) {
		String teamName = "", teamMechanics = "";
		int position = 0, i = 0, sizeMechanics = 0;
		Team team;
		teamName = JOptionPane.showInputDialog("Introduce el nombre de la escudería");
		position = findTeam(teams, teamName);
		if (position != -1) {
			team = teams.get(position);
			teamMechanics = "Mecánicos de " + team.getName() + "\n";
			sizeMechanics = team.getMechanics().size();
			while (i < sizeMechanics) {
				Mechanic mechanics = team.getMechanics().get(i);
				teamMechanics += mechanics + "\n";
				i++;
			}
			if (team.getMechanics().size() == 0) {
				teamMechanics = "No hay mecánicos en esta escudería";
			}
			JOptionPane.showMessageDialog(null, teamMechanics);
		} else {
			JOptionPane.showMessageDialog(null, "Error al introducir la escudería");
		}
	}

	public static void showTeams() {// no hace falta poner dentro ArrayList<Team>teams porque está declarada como
									// global
		String teamName = "";
		int position = 0;
		Team team;
		teamName = JOptionPane.showInputDialog("Introduce el nombre de la escudería");
		position = findTeam(teams, teamName);
		if (position != -1) {
			team = teams.get(position);
			JOptionPane.showMessageDialog(null, team);
		} else {
			JOptionPane.showMessageDialog(null, "Error al introducir la escudería");
		}
	}

	public static void showCars(ArrayList<Team> teams) {
		String teamName = "", teamCars = "";
		int position = 0, i = 0, sizeCars = 0;
		Team team;
		teamName = JOptionPane.showInputDialog("Introduce el nombre de la escudería");
		position = findTeam(teams, teamName);
		if (position != -1) {
			team = teams.get(position);
			teamCars = "Monoplazas de " + team.getName() + "\n";
			sizeCars = team.getCars().size();
			while (i < sizeCars) {
				Car cars = team.getCars().get(i);
				teamCars += cars + "\n";
				i++;
			}
			if (team.getCars().size() == 0) {
				teamCars = "No hay coches en esta escudería";
			}
			JOptionPane.showMessageDialog(null, teamCars);
		} else {
			JOptionPane.showMessageDialog(null, "Error al introducir la escudería");
		}
	}

	public static void findRemovePilot(ArrayList<Team> teams) {
		String dni = "";
		boolean toLook = false;
		int positionTeam = 0, positionPilot = 0;
		int checkTeam = teams.size(), checkPilot;
		Team currentTeam;
		Pilot currentPilot;
		dni = JOptionPane.showInputDialog("Introduzca su DNI o equivalente");

		while (positionTeam < checkTeam && !toLook) {
			currentTeam = teams.get(positionTeam);
			checkPilot = currentTeam.getPilots().size();
			positionPilot = 0;
			while (positionPilot < checkPilot && !toLook) {
				currentPilot = currentTeam.getPilots().get(positionPilot);
				if (currentPilot.getDni().equals(dni)) {
					int confirm = JOptionPane.showConfirmDialog(null,//currentPilot.toString()  si quiero imprimir todo sobre el piloto
							"¿Está seguro de que desea eliminar al siguiente piloto?\n" + "Nombre: "
									+ currentPilot.getName() + " Apellido: " + currentPilot.getSurname() + "\n"
									+ "DNI: " + currentPilot.getDni() + "  Escudería: " + currentTeam.getName(),
							"Confirmar eliminación", JOptionPane.YES_NO_OPTION);

					if (confirm == JOptionPane.YES_OPTION) {
						// Si el usuario confirma, eliminamos el piloto
						currentTeam.getPilots().remove(positionPilot);
						JOptionPane.showMessageDialog(null, "Piloto eliminado");
						toLook = true;
					} else {
						// Si el usuario cancela, no hacemos nada
						JOptionPane.showMessageDialog(null, "Eliminación cancelada");
						toLook = true; // Salimos del bucle
					}

					// toLook = true;
				}
				positionPilot++;
			}
			positionTeam++;
		}
	}

	public static void findRemoveMechanic(ArrayList<Team> teams) {
		String dni = "";
		boolean toLook = false;
		int positionTeam = 0, positionMechanic = 0;
		int checkTeam = teams.size(), checkMechanic;
		Team currentTeam;
		Mechanic currentMechanic;
		dni = JOptionPane.showInputDialog("Introduzca su DNI o equivalente");

		while (positionTeam < checkTeam && !toLook) {
			currentTeam = teams.get(positionTeam);
			checkMechanic = currentTeam.getMechanics().size();
			positionMechanic = 0;
			while (positionMechanic < checkMechanic && !toLook) {
				currentMechanic = currentTeam.getMechanics().get(positionMechanic);
				if (currentMechanic.getDni().equals(dni)) {
					int confirm = JOptionPane.showConfirmDialog(null,
							"¿Está seguro de que desea eliminar al siguiente piloto?\n" + "Nombre: "
									+ currentMechanic.getName() + " Apellido: " + currentMechanic.getSurname()
									+ "\n" + "DNI: " + currentMechanic.getDni() + " Escudería: "
									+ currentTeam.getName(),
							"Confirmar eliminación", JOptionPane.YES_NO_OPTION);

					if (confirm == JOptionPane.YES_OPTION) {
						// Si el usuario confirma, eliminamos el piloto
						currentTeam.getMechanics().remove(positionMechanic);
						JOptionPane.showMessageDialog(null, "Piloto eliminado");
						toLook = true;
					} else {
						// Si el usuario cancela, no hacemos nada
						JOptionPane.showMessageDialog(null, "Eliminación cancelada");
						toLook = true; // Salimos del bucle
					}

				}
				positionMechanic++;
			}
			positionTeam++;
		}
	}

	public static int findTeam(ArrayList<Team> teams, String check) {
		int position = -1;
		boolean toLook = false;
		int i = 0;
		int turn = teams.size();
		while (i < turn && !toLook) {
			if (check.equalsIgnoreCase(teams.get(i).getName())) {
				position = i;
				toLook = true;
			}
			i++;
		}
		return position;
	}

	public static ArrayList<Integer> findPilot(String check) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		boolean toLook = false;
		int i = 0, j = 0;// i = position team, j position pilot
		int turn = teams.size();
		while (i < turn && !toLook) {
			j = 0;
			while (j < teams.get(i).pilots.size() && !toLook) {
				if (check.equalsIgnoreCase(teams.get(i).pilots.get(j).getDni())) {
					toLook = true;
					positions.add(i);
					positions.add(j);
				}
				j++;
			}
			i++;
		}
		return positions;
	}

	public static int findDuplicatePilot(ArrayList<Team> teams, String check) {
		int position = -1;
		boolean toLook = false;
		int i = 0, j = 0;
		int checkTeam = teams.size(), checkPilot;
		Team currentTeam;

		while (i < checkTeam && !toLook) {
			currentTeam = teams.get(i);
			checkPilot = currentTeam.getPilots().size();
			j = 0;
			while (j < checkPilot && !toLook) {
				if (check.equals(currentTeam.getPilots().get(j).getDni())) {
					position = j;
					toLook = true;
				}
				j++;
			}
			i++;
		}
		return position;
	}

	public static int findDuplicateMechanic(ArrayList<Team> teams, String check) {
		int position = -1;
		boolean toLook = false;
		int i = 0, j = 0;
		int checkTeam = teams.size(), checkMechanic;
		Team currentTeam;

		while (i < checkTeam && !toLook) {
			currentTeam = teams.get(i);
			checkMechanic = currentTeam.getMechanics().size();
			j = 0;
			while (j < checkMechanic && !toLook) {
				if (check.equals(currentTeam.getMechanics().get(j).getDni())) {
					position = j;
					toLook = true;
				}
				j++;
			}
			i++;
		}
		return position;
	}

}
