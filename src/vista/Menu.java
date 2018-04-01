
package vista;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VistaDeAsistenciaDiaria = new javax.swing.JDialog();
        panel1 = new org.edisoncor.gui.panel.Panel();
        btnIniciarJornada = new org.edisoncor.gui.button.ButtonTask();
        btnFinalizarJornada = new org.edisoncor.gui.button.ButtonTask();
        relojDigital = new org.edisoncor.gui.varios.ClockDigital();
        panel2 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeAsistencia = new javax.swing.JTable();
        lblFecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBusquedaPorCedula = new org.edisoncor.gui.textField.TextFieldRectImage();
        btnEntrada = new org.edisoncor.gui.button.ButtonTask();
        btnSalida = new org.edisoncor.gui.button.ButtonTask();
        btnReporte = new org.edisoncor.gui.button.ButtonTask();
        jLabel1 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblHoraInicio = new javax.swing.JLabel();
        lblHoraCierre = new javax.swing.JLabel();
        ReporteDeInasistenciaActual = new javax.swing.JDialog();
        panel3 = new org.edisoncor.gui.panel.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaDeInasistencias = new javax.swing.JTable();
        lblFechaDeInasistencia = new javax.swing.JLabel();
        Empleados = new javax.swing.JDialog();
        panel4 = new org.edisoncor.gui.panel.Panel();
        panel5 = new org.edisoncor.gui.panel.Panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaDeEmpleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtEmpleadoABuscar = new org.edisoncor.gui.textField.TextFieldRectIcon();
        btnNuevoEmpleado = new org.edisoncor.gui.button.ButtonTask();
        buttonTask1 = new org.edisoncor.gui.button.ButtonTask();
        NuevoEmpleado = new javax.swing.JDialog();
        panel6 = new org.edisoncor.gui.panel.Panel();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombreEmpleado = new org.edisoncor.gui.textField.TextFieldRectImage();
        jLabel6 = new javax.swing.JLabel();
        txtApellidoEmpleado = new org.edisoncor.gui.textField.TextFieldRectImage();
        jLabel7 = new javax.swing.JLabel();
        txtDepartamentoAsignado = new org.edisoncor.gui.textField.TextFieldRectImage();
        btnGuardarEmpleado = new javax.swing.JButton();
        btnAgregarDepartamento = new javax.swing.JButton();
        VistaSeleccionarDepartamento = new javax.swing.JDialog();
        panel7 = new org.edisoncor.gui.panel.Panel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listadoDeDepartamentos = new javax.swing.JTable();
        btnAsignar = new javax.swing.JButton();
        Login = new javax.swing.JDialog();
        panel8 = new org.edisoncor.gui.panel.Panel();
        txtNombreDeUsuario = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txtClave = new org.edisoncor.gui.passwordField.PasswordFieldRoundImage();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        InasistenciaPersonal = new javax.swing.JDialog();
        panel9 = new org.edisoncor.gui.panel.Panel();
        mesInasistencia = new com.toedter.calendar.JMonthChooser();
        yearInasistencia = new com.toedter.calendar.JYearChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaDeInasistenciaPorEmpleado = new javax.swing.JTable();
        btnConsultarInasistencia = new javax.swing.JButton();
        btnCrearJustificacion = new javax.swing.JButton();
        VistaReporteDeAsistencia = new javax.swing.JDialog();
        panel12 = new org.edisoncor.gui.panel.Panel();
        calendarFechaConsulta = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaReportAsistencia = new javax.swing.JTable();
        btnVerReporteDeAsistencia = new org.edisoncor.gui.button.ButtonTask();
        VistaJustificacion = new javax.swing.JDialog();
        panel13 = new org.edisoncor.gui.panel.Panel();
        btnJustificar = new org.edisoncor.gui.button.ButtonAction();
        jScrollPane8 = new javax.swing.JScrollPane();
        areaObservacion = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblHoraDeGeneracion = new javax.swing.JLabel();
        VistaBuscarEmpleado = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btnBuscarEmpleado = new javax.swing.JButton();
        txtCedulaEmpleadoBuscar = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        VistaSubMenu = new javax.swing.JDialog();
        panelSubMenu = new javax.swing.JPanel();
        panelDeFunciones = new javax.swing.JPanel();
        btnInformacionPersonal = new org.edisoncor.gui.button.ButtonTask();
        btnInasistenciasDeEmpleado = new org.edisoncor.gui.button.ButtonTask();
        btnPermisosEmpleado = new org.edisoncor.gui.button.ButtonTask();
        btnSalirEmpleado = new org.edisoncor.gui.button.ButtonTask();
        panelInformacionDeEmpleado = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lblNombreEmpleado = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblApellidosEmpleado = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblDepartamentoEmpleado = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblCedulaEmpleado = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        NuevoPermiso = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        lblFechaDeEmision = new javax.swing.JLabel();
        btnEmitir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        fechaDeIncio = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txtDiasDePermiso = new javax.swing.JSpinner();
        VistaPermisos = new javax.swing.JDialog();
        panelDeImagen = new org.edisoncor.gui.panel.PanelImage();
        barraDeMenu = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        itemEmpleados = new javax.swing.JMenuItem();
        Control = new javax.swing.JMenu();
        itemAsistenciaDiaria = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        itemEntradaSalida = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();
        itemManual = new javax.swing.JMenuItem();

        VistaDeAsistenciaDiaria.setTitle("Asistencia diaria");

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(204, 204, 204));

        btnIniciarJornada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_special-offer_59207.png"))); // NOI18N
        btnIniciarJornada.setText("INICIAR JORNADA");
        btnIniciarJornada.setDescription("Nuevo día");

        btnFinalizarJornada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_No_984759.png"))); // NOI18N
        btnFinalizarJornada.setText("FINALIZAR JORNADA");
        btnFinalizarJornada.setDescription("Fin del día");

        relojDigital.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N

        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Asistencia de hoy"));
        panel2.setColorPrimario(new java.awt.Color(204, 204, 204));
        panel2.setColorSecundario(new java.awt.Color(204, 204, 204));

        listaDeAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Empleado", "Departamento", "Hora de entrada", "Hora de salida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaDeAsistencia.setFocusable(false);
        listaDeAsistencia.setRowHeight(30);
        listaDeAsistencia.setRowMargin(5);
        listaDeAsistencia.setSelectionBackground(new java.awt.Color(204, 204, 204));
        listaDeAsistencia.setShowHorizontalLines(false);
        listaDeAsistencia.setShowVerticalLines(false);
        listaDeAsistencia.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(listaDeAsistencia);
        if (listaDeAsistencia.getColumnModel().getColumnCount() > 0) {
            listaDeAsistencia.getColumnModel().getColumn(0).setResizable(false);
            listaDeAsistencia.getColumnModel().getColumn(1).setResizable(false);
            listaDeAsistencia.getColumnModel().getColumn(2).setResizable(false);
            listaDeAsistencia.getColumnModel().getColumn(3).setResizable(false);
            listaDeAsistencia.getColumnModel().getColumn(4).setResizable(false);
        }

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFecha.setText("FECHA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Búsqueda por cédula");

        txtBusquedaPorCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblFecha)
                        .addGap(163, 163, 163)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusquedaPorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(jLabel2)
                    .addComponent(txtBusquedaPorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_check_59131.png"))); // NOI18N
        btnEntrada.setText("Entrada");
        btnEntrada.setDescription("Marcar");

        btnSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_check_59131.png"))); // NOI18N
        btnSalida.setText("Salida");
        btnSalida.setDescription("Marcar");

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_order-2_59180.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.setDescription("Relación de asistencia de hoy");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jornada de hoy:");

        lblEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText("ESTADO");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Hora de inicio:");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Hora de cierre:");

        lblHoraInicio.setText("00:00:00");

        lblHoraCierre.setText("00:00:00");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(relojDigital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(231, 231, 231)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblHoraCierre))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblHoraInicio))))))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(193, 193, 193)
                                        .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(125, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnIniciarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblEstado)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblHoraInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblHoraCierre))
                        .addGap(25, 25, 25)
                        .addComponent(relojDigital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout VistaDeAsistenciaDiariaLayout = new javax.swing.GroupLayout(VistaDeAsistenciaDiaria.getContentPane());
        VistaDeAsistenciaDiaria.getContentPane().setLayout(VistaDeAsistenciaDiariaLayout);
        VistaDeAsistenciaDiariaLayout.setHorizontalGroup(
            VistaDeAsistenciaDiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        VistaDeAsistenciaDiariaLayout.setVerticalGroup(
            VistaDeAsistenciaDiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ReporteDeInasistenciaActual.setTitle("Inasistencias de Hoy");

        panel3.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel3.setColorSecundario(new java.awt.Color(204, 204, 204));

        listaDeInasistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cédula", "Empleado", "Motivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaDeInasistencias.setFocusable(false);
        listaDeInasistencias.setRowHeight(30);
        listaDeInasistencias.setRowMargin(10);
        listaDeInasistencias.setSelectionBackground(java.awt.Color.lightGray);
        listaDeInasistencias.setShowHorizontalLines(false);
        listaDeInasistencias.setShowVerticalLines(false);
        listaDeInasistencias.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(listaDeInasistencias);
        if (listaDeInasistencias.getColumnModel().getColumnCount() > 0) {
            listaDeInasistencias.getColumnModel().getColumn(0).setResizable(false);
            listaDeInasistencias.getColumnModel().getColumn(1).setResizable(false);
            listaDeInasistencias.getColumnModel().getColumn(2).setResizable(false);
        }

        lblFechaDeInasistencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFechaDeInasistencia.setText("Fecha");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblFechaDeInasistencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblFechaDeInasistencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout ReporteDeInasistenciaActualLayout = new javax.swing.GroupLayout(ReporteDeInasistenciaActual.getContentPane());
        ReporteDeInasistenciaActual.getContentPane().setLayout(ReporteDeInasistenciaActualLayout);
        ReporteDeInasistenciaActualLayout.setHorizontalGroup(
            ReporteDeInasistenciaActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ReporteDeInasistenciaActualLayout.setVerticalGroup(
            ReporteDeInasistenciaActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Empleados.setTitle("Empleados Oderi");

        panel4.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel4.setColorSecundario(new java.awt.Color(204, 204, 204));

        panel5.setColorPrimario(new java.awt.Color(204, 204, 204));
        panel5.setColorSecundario(new java.awt.Color(204, 204, 204));

        listaDeEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaDeEmpleados.setFocusable(false);
        listaDeEmpleados.setRowHeight(30);
        listaDeEmpleados.setRowMargin(3);
        listaDeEmpleados.setSelectionBackground(new java.awt.Color(204, 204, 204));
        listaDeEmpleados.setShowHorizontalLines(false);
        listaDeEmpleados.setShowVerticalLines(false);
        listaDeEmpleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(listaDeEmpleados);
        if (listaDeEmpleados.getColumnModel().getColumnCount() > 0) {
            listaDeEmpleados.getColumnModel().getColumn(0).setResizable(false);
            listaDeEmpleados.getColumnModel().getColumn(1).setResizable(false);
            listaDeEmpleados.getColumnModel().getColumn(2).setResizable(false);
            listaDeEmpleados.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Búsqueda por cédula");

        txtEmpleadoABuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmpleadoABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmpleadoABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevoEmpleado.setText("Nuevo");
        btnNuevoEmpleado.setDescription("Registrar empleado");

        buttonTask1.setText("Editar");
        buttonTask1.setDescription("cambiar información del empleado");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(btnNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonTask1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTask1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout EmpleadosLayout = new javax.swing.GroupLayout(Empleados.getContentPane());
        Empleados.getContentPane().setLayout(EmpleadosLayout);
        EmpleadosLayout.setHorizontalGroup(
            EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpleadosLayout.createSequentialGroup()
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        EmpleadosLayout.setVerticalGroup(
            EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        NuevoEmpleado.setTitle("Nuevo empleado");

        panel6.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel6.setColorSecundario(java.awt.Color.white);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cédula");

        txtCedula.setEditable(false);
        txtCedula.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nombre");

        txtNombreEmpleado.setBackground(java.awt.Color.white);
        txtNombreEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Apellido");

        txtApellidoEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Departamento");

        txtDepartamentoAsignado.setEditable(false);
        txtDepartamentoAsignado.setBackground(new java.awt.Color(255, 255, 255));
        txtDepartamentoAsignado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnGuardarEmpleado.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnGuardarEmpleado.setText("Guardar");

        btnAgregarDepartamento.setText("+");

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel6Layout.createSequentialGroup()
                        .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedula)
                            .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDepartamentoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarEmpleado)
                .addGap(22, 22, 22))
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDepartamentoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(btnGuardarEmpleado)
                .addContainerGap())
        );

        javax.swing.GroupLayout NuevoEmpleadoLayout = new javax.swing.GroupLayout(NuevoEmpleado.getContentPane());
        NuevoEmpleado.getContentPane().setLayout(NuevoEmpleadoLayout);
        NuevoEmpleadoLayout.setHorizontalGroup(
            NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        NuevoEmpleadoLayout.setVerticalGroup(
            NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        VistaSeleccionarDepartamento.setTitle("Lista de Departamentos");

        panel7.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel7.setColorSecundario(new java.awt.Color(204, 204, 204));

        listadoDeDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listadoDeDepartamentos.setFocusable(false);
        listadoDeDepartamentos.setRowHeight(30);
        listadoDeDepartamentos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        listadoDeDepartamentos.setShowHorizontalLines(false);
        listadoDeDepartamentos.setShowVerticalLines(false);
        listadoDeDepartamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(listadoDeDepartamentos);
        if (listadoDeDepartamentos.getColumnModel().getColumnCount() > 0) {
            listadoDeDepartamentos.getColumnModel().getColumn(0).setResizable(false);
            listadoDeDepartamentos.getColumnModel().getColumn(1).setResizable(false);
        }

        btnAsignar.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnAsignar.setText("asignar");

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAsignar)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnAsignar)
                .addContainerGap())
        );

        javax.swing.GroupLayout VistaSeleccionarDepartamentoLayout = new javax.swing.GroupLayout(VistaSeleccionarDepartamento.getContentPane());
        VistaSeleccionarDepartamento.getContentPane().setLayout(VistaSeleccionarDepartamentoLayout);
        VistaSeleccionarDepartamentoLayout.setHorizontalGroup(
            VistaSeleccionarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        VistaSeleccionarDepartamentoLayout.setVerticalGroup(
            VistaSeleccionarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Login.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Login.setTitle("Login");

        panel8.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel8.setColorSecundario(java.awt.Color.white);

        txtNombreDeUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel17.setForeground(java.awt.Color.darkGray);
        jLabel17.setText("Usuario");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel18.setForeground(java.awt.Color.darkGray);
        jLabel18.setText("Contraseña");

        btnEntrar.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnEntrar.setText("entrar ");

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addGap(0, 228, Short.MAX_VALUE)
                .addComponent(btnEntrar)
                .addGap(30, 30, 30))
            .addGroup(panel8Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addComponent(txtNombreDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnEntrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login.getContentPane());
        Login.getContentPane().setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        InasistenciaPersonal.setTitle("Inasistencias mensuales del empleado");

        panel9.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel9.setColorSecundario(java.awt.Color.white);

        mesInasistencia.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Mes");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Año");

        listaDeInasistenciaPorEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Día", "Motivo", "Justificada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaDeInasistenciaPorEmpleado.setFocusable(false);
        listaDeInasistenciaPorEmpleado.setRowHeight(30);
        listaDeInasistenciaPorEmpleado.setSelectionBackground(new java.awt.Color(204, 204, 204));
        listaDeInasistenciaPorEmpleado.setShowHorizontalLines(false);
        listaDeInasistenciaPorEmpleado.setShowVerticalLines(false);
        listaDeInasistenciaPorEmpleado.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(listaDeInasistenciaPorEmpleado);
        if (listaDeInasistenciaPorEmpleado.getColumnModel().getColumnCount() > 0) {
            listaDeInasistenciaPorEmpleado.getColumnModel().getColumn(0).setResizable(false);
            listaDeInasistenciaPorEmpleado.getColumnModel().getColumn(1).setResizable(false);
            listaDeInasistenciaPorEmpleado.getColumnModel().getColumn(2).setResizable(false);
            listaDeInasistenciaPorEmpleado.getColumnModel().getColumn(3).setResizable(false);
        }

        btnConsultarInasistencia.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnConsultarInasistencia.setText("consultar");

        btnCrearJustificacion.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnCrearJustificacion.setText("crear justificación");

        javax.swing.GroupLayout panel9Layout = new javax.swing.GroupLayout(panel9);
        panel9.setLayout(panel9Layout);
        panel9Layout.setHorizontalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCrearJustificacion)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                        .addComponent(btnConsultarInasistencia)
                        .addGap(226, 226, 226))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mesInasistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearInasistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
        );
        panel9Layout.setVerticalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mesInasistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearInasistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(29, 29, 29)
                .addComponent(btnConsultarInasistencia)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnCrearJustificacion)
                .addContainerGap())
        );

        javax.swing.GroupLayout InasistenciaPersonalLayout = new javax.swing.GroupLayout(InasistenciaPersonal.getContentPane());
        InasistenciaPersonal.getContentPane().setLayout(InasistenciaPersonalLayout);
        InasistenciaPersonalLayout.setHorizontalGroup(
            InasistenciaPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InasistenciaPersonalLayout.setVerticalGroup(
            InasistenciaPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        VistaReporteDeAsistencia.setTitle("Entradas y Salidas");

        panel12.setColorPrimario(java.awt.Color.white);
        panel12.setColorSecundario(java.awt.Color.lightGray);

        jLabel19.setText("Fecha del reporte");

        tablaReportAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Empleado", "Entró", "Salió", "Hrs. Trabajadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaReportAsistencia.setFocusable(false);
        tablaReportAsistencia.setRowHeight(30);
        tablaReportAsistencia.setSelectionBackground(java.awt.Color.lightGray);
        tablaReportAsistencia.setShowHorizontalLines(false);
        tablaReportAsistencia.setShowVerticalLines(false);
        tablaReportAsistencia.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tablaReportAsistencia);
        if (tablaReportAsistencia.getColumnModel().getColumnCount() > 0) {
            tablaReportAsistencia.getColumnModel().getColumn(0).setResizable(false);
            tablaReportAsistencia.getColumnModel().getColumn(1).setResizable(false);
            tablaReportAsistencia.getColumnModel().getColumn(2).setResizable(false);
            tablaReportAsistencia.getColumnModel().getColumn(3).setResizable(false);
            tablaReportAsistencia.getColumnModel().getColumn(4).setResizable(false);
        }

        btnVerReporteDeAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_calendar_2_42176.png"))); // NOI18N
        btnVerReporteDeAsistencia.setText("Ver");
        btnVerReporteDeAsistencia.setDescription("Entradas y salidas");

        javax.swing.GroupLayout panel12Layout = new javax.swing.GroupLayout(panel12);
        panel12.setLayout(panel12Layout);
        panel12Layout.setHorizontalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel12Layout.createSequentialGroup()
                .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel12Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel12Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel19)
                        .addGap(3, 3, 3)
                        .addComponent(calendarFechaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVerReporteDeAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        panel12Layout.setVerticalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel12Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(calendarFechaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addComponent(btnVerReporteDeAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout VistaReporteDeAsistenciaLayout = new javax.swing.GroupLayout(VistaReporteDeAsistencia.getContentPane());
        VistaReporteDeAsistencia.getContentPane().setLayout(VistaReporteDeAsistenciaLayout);
        VistaReporteDeAsistenciaLayout.setHorizontalGroup(
            VistaReporteDeAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        VistaReporteDeAsistenciaLayout.setVerticalGroup(
            VistaReporteDeAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        VistaJustificacion.setTitle("Justificar inasistencia");

        panel13.setBackground(java.awt.Color.white);
        panel13.setColorPrimario(java.awt.Color.white);
        panel13.setColorSecundario(java.awt.Color.white);

        btnJustificar.setText("Justificar");

        areaObservacion.setColumns(20);
        areaObservacion.setRows(5);
        jScrollPane8.setViewportView(areaObservacion);

        jLabel20.setText("Observación");

        jLabel22.setText("Hora de generación:");

        lblHoraDeGeneracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoraDeGeneracion.setText("Hora");

        javax.swing.GroupLayout panel13Layout = new javax.swing.GroupLayout(panel13);
        panel13.setLayout(panel13Layout);
        panel13Layout.setHorizontalGroup(
            panel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnJustificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel13Layout.createSequentialGroup()
                        .addGroup(panel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel13Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblHoraDeGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel13Layout.setVerticalGroup(
            panel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel13Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(panel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblHoraDeGeneracion))
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnJustificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout VistaJustificacionLayout = new javax.swing.GroupLayout(VistaJustificacion.getContentPane());
        VistaJustificacion.getContentPane().setLayout(VistaJustificacionLayout);
        VistaJustificacionLayout.setHorizontalGroup(
            VistaJustificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        VistaJustificacionLayout.setVerticalGroup(
            VistaJustificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        VistaBuscarEmpleado.setTitle("Buscar empleado");

        jPanel1.setBackground(java.awt.Color.white);

        jLabel23.setText("Cédula");

        btnBuscarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_Black_Search_60944.png"))); // NOI18N
        btnBuscarEmpleado.setText("buscar");

        txtCedulaEmpleadoBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel25.setText("Ej. 22222222");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedulaEmpleadoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarEmpleado)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtCedulaEmpleadoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnBuscarEmpleado)
                .addContainerGap())
        );

        javax.swing.GroupLayout VistaBuscarEmpleadoLayout = new javax.swing.GroupLayout(VistaBuscarEmpleado.getContentPane());
        VistaBuscarEmpleado.getContentPane().setLayout(VistaBuscarEmpleadoLayout);
        VistaBuscarEmpleadoLayout.setHorizontalGroup(
            VistaBuscarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        VistaBuscarEmpleadoLayout.setVerticalGroup(
            VistaBuscarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelSubMenu.setBackground(java.awt.Color.white);

        panelDeFunciones.setBackground(java.awt.Color.white);
        panelDeFunciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Panel de opciones"));
        panelDeFunciones.setLayout(new java.awt.GridLayout(4, 1));

        btnInformacionPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_my-account_59177.png"))); // NOI18N
        btnInformacionPersonal.setText("Información");
        btnInformacionPersonal.setDescription("Datos del empleado");
        panelDeFunciones.add(btnInformacionPersonal);

        btnInasistenciasDeEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_calendar_2_42176.png"))); // NOI18N
        btnInasistenciasDeEmpleado.setText("Inasistencias");
        btnInasistenciasDeEmpleado.setDescription("Mensuales");
        panelDeFunciones.add(btnInasistenciasDeEmpleado);

        btnPermisosEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_order-2_59180.png"))); // NOI18N
        btnPermisosEmpleado.setText("Permisos");
        btnPermisosEmpleado.setDescription("Solicitudes");
        panelDeFunciones.add(btnPermisosEmpleado);

        btnSalirEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon/if_logout_59175.png"))); // NOI18N
        btnSalirEmpleado.setText("Salir");
        btnSalirEmpleado.setDescription("  ");
        panelDeFunciones.add(btnSalirEmpleado);

        panelInformacionDeEmpleado.setBackground(java.awt.Color.white);
        panelInformacionDeEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel27.setText("Nombre(es):");

        lblNombreEmpleado.setText("nombre");

        jLabel28.setText("Apellidos:");

        lblApellidosEmpleado.setText("apellidos");

        jLabel29.setText("Departamento:");

        lblDepartamentoEmpleado.setText("departamento");

        jLabel30.setText("Cédula:");

        lblCedulaEmpleado.setText("cedula");

        jButton3.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jButton3.setText("Editar");

        javax.swing.GroupLayout panelInformacionDeEmpleadoLayout = new javax.swing.GroupLayout(panelInformacionDeEmpleado);
        panelInformacionDeEmpleado.setLayout(panelInformacionDeEmpleadoLayout);
        panelInformacionDeEmpleadoLayout.setHorizontalGroup(
            panelInformacionDeEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionDeEmpleadoLayout.createSequentialGroup()
                .addGroup(panelInformacionDeEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionDeEmpleadoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(panelInformacionDeEmpleadoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelInformacionDeEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInformacionDeEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCedulaEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellidosEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDepartamentoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(0, 207, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInformacionDeEmpleadoLayout.setVerticalGroup(
            panelInformacionDeEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionDeEmpleadoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelInformacionDeEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lblCedulaEmpleado))
                .addGap(18, 18, 18)
                .addGroup(panelInformacionDeEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblNombreEmpleado))
                .addGap(18, 18, 18)
                .addGroup(panelInformacionDeEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lblApellidosEmpleado))
                .addGap(18, 18, 18)
                .addGroup(panelInformacionDeEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lblDepartamentoEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSubMenuLayout = new javax.swing.GroupLayout(panelSubMenu);
        panelSubMenu.setLayout(panelSubMenuLayout);
        panelSubMenuLayout.setHorizontalGroup(
            panelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDeFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInformacionDeEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSubMenuLayout.setVerticalGroup(
            panelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubMenuLayout.createSequentialGroup()
                .addGroup(panelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSubMenuLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(panelDeFunciones, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                    .addGroup(panelSubMenuLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(panelInformacionDeEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout VistaSubMenuLayout = new javax.swing.GroupLayout(VistaSubMenu.getContentPane());
        VistaSubMenu.getContentPane().setLayout(VistaSubMenuLayout);
        VistaSubMenuLayout.setHorizontalGroup(
            VistaSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        VistaSubMenuLayout.setVerticalGroup(
            VistaSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(java.awt.Color.white);

        lblFechaDeEmision.setText("Fecha de Emision");

        btnEmitir.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        btnEmitir.setText("Emitir");

        jLabel10.setText("Días de permiso");

        jLabel13.setText("Fecha de inicio");

        jLabel14.setText("Fecha de elaboración:");

        txtDiasDePermiso.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(lblFechaDeEmision)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnEmitir)
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaDeIncio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiasDePermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaDeEmision)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaDeIncio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiasDePermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(45, 45, 45)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmitir)
                .addContainerGap())
        );

        javax.swing.GroupLayout NuevoPermisoLayout = new javax.swing.GroupLayout(NuevoPermiso.getContentPane());
        NuevoPermiso.getContentPane().setLayout(NuevoPermisoLayout);
        NuevoPermisoLayout.setHorizontalGroup(
            NuevoPermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        NuevoPermisoLayout.setVerticalGroup(
            NuevoPermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout VistaPermisosLayout = new javax.swing.GroupLayout(VistaPermisos.getContentPane());
        VistaPermisos.getContentPane().setLayout(VistaPermisosLayout);
        VistaPermisosLayout.setHorizontalGroup(
            VistaPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        VistaPermisosLayout.setVerticalGroup(
            VistaPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cacao Oderí");

        panelDeImagen.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout panelDeImagenLayout = new javax.swing.GroupLayout(panelDeImagen);
        panelDeImagen.setLayout(panelDeImagenLayout);
        panelDeImagenLayout.setHorizontalGroup(
            panelDeImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        panelDeImagenLayout.setVerticalGroup(
            panelDeImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        barraDeMenu.setFocusable(false);

        Archivo.setText("Archivo");
        Archivo.setRequestFocusEnabled(false);

        itemEmpleados.setText("Empleado");
        Archivo.add(itemEmpleados);

        barraDeMenu.add(Archivo);

        Control.setText("Control");

        itemAsistenciaDiaria.setText("Registro de asistencias");
        Control.add(itemAsistenciaDiaria);

        barraDeMenu.add(Control);

        Consultas.setText("Consultas");

        jMenu1.setText("Asistencias");

        itemEntradaSalida.setText("Entrada y Salida");
        jMenu1.add(itemEntradaSalida);

        Consultas.add(jMenu1);

        barraDeMenu.add(Consultas);

        Ayuda.setText("Ayuda");

        itemManual.setText("Sobre la aplicación");
        Ayuda.add(itemManual);

        barraDeMenu.add(Ayuda);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDeImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDeImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Ayuda;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenu Control;
    public javax.swing.JDialog Empleados;
    public javax.swing.JDialog InasistenciaPersonal;
    public javax.swing.JDialog Login;
    public javax.swing.JDialog NuevoEmpleado;
    private javax.swing.JDialog NuevoPermiso;
    public javax.swing.JDialog ReporteDeInasistenciaActual;
    public javax.swing.JDialog VistaBuscarEmpleado;
    public javax.swing.JDialog VistaDeAsistenciaDiaria;
    public javax.swing.JDialog VistaJustificacion;
    private javax.swing.JDialog VistaPermisos;
    public javax.swing.JDialog VistaReporteDeAsistencia;
    public javax.swing.JDialog VistaSeleccionarDepartamento;
    public javax.swing.JDialog VistaSubMenu;
    public javax.swing.JTextArea areaObservacion;
    private javax.swing.JMenuBar barraDeMenu;
    public javax.swing.JButton btnAgregarDepartamento;
    public javax.swing.JButton btnAsignar;
    public javax.swing.JButton btnBuscarEmpleado;
    public javax.swing.JButton btnConsultarInasistencia;
    public javax.swing.JButton btnCrearJustificacion;
    public javax.swing.JButton btnEmitir;
    public org.edisoncor.gui.button.ButtonTask btnEntrada;
    public javax.swing.JButton btnEntrar;
    public org.edisoncor.gui.button.ButtonTask btnFinalizarJornada;
    public javax.swing.JButton btnGuardarEmpleado;
    public org.edisoncor.gui.button.ButtonTask btnInasistenciasDeEmpleado;
    public org.edisoncor.gui.button.ButtonTask btnInformacionPersonal;
    public org.edisoncor.gui.button.ButtonTask btnIniciarJornada;
    public org.edisoncor.gui.button.ButtonAction btnJustificar;
    public org.edisoncor.gui.button.ButtonTask btnNuevoEmpleado;
    public org.edisoncor.gui.button.ButtonTask btnPermisosEmpleado;
    public org.edisoncor.gui.button.ButtonTask btnReporte;
    public org.edisoncor.gui.button.ButtonTask btnSalida;
    public org.edisoncor.gui.button.ButtonTask btnSalirEmpleado;
    public org.edisoncor.gui.button.ButtonTask btnVerReporteDeAsistencia;
    private org.edisoncor.gui.button.ButtonTask buttonTask1;
    public com.toedter.calendar.JDateChooser calendarFechaConsulta;
    public com.toedter.calendar.JDateChooser fechaDeIncio;
    public javax.swing.JMenuItem itemAsistenciaDiaria;
    public javax.swing.JMenuItem itemEmpleados;
    public javax.swing.JMenuItem itemEntradaSalida;
    private javax.swing.JMenuItem itemManual;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblApellidosEmpleado;
    public javax.swing.JLabel lblCedulaEmpleado;
    public javax.swing.JLabel lblDepartamentoEmpleado;
    public javax.swing.JLabel lblEstado;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblFechaDeEmision;
    public javax.swing.JLabel lblFechaDeInasistencia;
    public javax.swing.JLabel lblHoraCierre;
    public javax.swing.JLabel lblHoraDeGeneracion;
    public javax.swing.JLabel lblHoraInicio;
    public javax.swing.JLabel lblNombreEmpleado;
    public javax.swing.JTable listaDeAsistencia;
    public javax.swing.JTable listaDeEmpleados;
    public javax.swing.JTable listaDeInasistenciaPorEmpleado;
    public javax.swing.JTable listaDeInasistencias;
    public javax.swing.JTable listadoDeDepartamentos;
    public com.toedter.calendar.JMonthChooser mesInasistencia;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel12;
    private org.edisoncor.gui.panel.Panel panel13;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.Panel panel3;
    private org.edisoncor.gui.panel.Panel panel4;
    private org.edisoncor.gui.panel.Panel panel5;
    private org.edisoncor.gui.panel.Panel panel6;
    private org.edisoncor.gui.panel.Panel panel7;
    private org.edisoncor.gui.panel.Panel panel8;
    private org.edisoncor.gui.panel.Panel panel9;
    private javax.swing.JPanel panelDeFunciones;
    private org.edisoncor.gui.panel.PanelImage panelDeImagen;
    public javax.swing.JPanel panelInformacionDeEmpleado;
    private javax.swing.JPanel panelSubMenu;
    public org.edisoncor.gui.varios.ClockDigital relojDigital;
    public javax.swing.JTable tablaReportAsistencia;
    public org.edisoncor.gui.textField.TextFieldRectImage txtApellidoEmpleado;
    public org.edisoncor.gui.textField.TextFieldRectImage txtBusquedaPorCedula;
    public javax.swing.JFormattedTextField txtCedula;
    public javax.swing.JTextField txtCedulaEmpleadoBuscar;
    public org.edisoncor.gui.passwordField.PasswordFieldRoundImage txtClave;
    public org.edisoncor.gui.textField.TextFieldRectImage txtDepartamentoAsignado;
    public javax.swing.JSpinner txtDiasDePermiso;
    public org.edisoncor.gui.textField.TextFieldRectIcon txtEmpleadoABuscar;
    public org.edisoncor.gui.textField.TextFieldRoundImage txtNombreDeUsuario;
    public org.edisoncor.gui.textField.TextFieldRectImage txtNombreEmpleado;
    public com.toedter.calendar.JYearChooser yearInasistencia;
    // End of variables declaration//GEN-END:variables

}