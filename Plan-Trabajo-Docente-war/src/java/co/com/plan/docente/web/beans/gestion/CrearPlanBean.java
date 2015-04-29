/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plan.docente.web.beans.gestion;

import co.com.plan.docente.entities.ActExtAcademica;
import co.com.plan.docente.entities.Actividad;
import co.com.plan.docente.entities.AsesoriaProyecto;
import co.com.plan.docente.entities.ComisionEstudio;
import co.com.plan.docente.entities.Consejo;
import co.com.plan.docente.entities.DistribucionActividad;
import co.com.plan.docente.entities.DocenciaDirecta;
import co.com.plan.docente.entities.Docente;
import co.com.plan.docente.entities.Facultad;
import co.com.plan.docente.entities.Investigacion;
import co.com.plan.docente.entities.Materia;
import co.com.plan.docente.entities.Publicacion;
import co.com.plan.docente.entities.Usuario;
import co.com.plan.docente.forentities.DocenteFacadeLocal;
import co.com.plan.docente.forentities.FacultadFacadeLocal;
import co.com.plan.docente.forentities.InvestigacionFacadeLocal;
import co.com.plan.docente.forentities.MateriaFacadeLocal;
import co.com.plan.docente.forentities.UsuarioFacadeLocal;
import co.com.plan.docente.web.util.AccionesGenerico;
import javax.faces.application.FacesMessage;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.primefaces.event.FlowEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author 727855
 */
@ManagedBean
@ViewScoped
public class CrearPlanBean {

    /**
     * Creates a new instance of CrearPlanBean
     */
    public CrearPlanBean() {
    }
    private static final long serialVersionUID = 1L;

    private Docente docente;
    private List<Docente> docentes;
    private Materia materia;
    private List<Materia> materias;
    private ActExtAcademica actExtAcademica;
    private List<ActExtAcademica> listActExtAcademicas;
    private Actividad actividad;
    private List<Actividad> Actividades;
    private Investigacion investigacion;
    private List<Investigacion> investigaciones;
    private AsesoriaProyecto asesoriaProyecto;
    private List<AsesoriaProyecto> listAsesoriaProyectos;
    private ComisionEstudio comisionEstudio;
    private List<ComisionEstudio> listComisionEstudios;
    private Consejo consejo;
    private List<Consejo> listConsejos;
    private DistribucionActividad distribucionActividad;
    private List<DistribucionActividad> listDistribucionActividades;
    private DocenciaDirecta docenciaDirecta;
    private List<DocenciaDirecta> listDocenciaDirecta;
    private Facultad facultad;
    private List<Facultad> facultades;
    private Publicacion publicacion;
    private List<Publicacion> listPublicaciones;
    private Usuario usuario;
    private Converter facultadConverter;
    private Converter materiaConverter;
    private boolean mostar;
    private boolean skip;
    private String codigoMateria;

//<editor-fold defaultstate="collapsed" desc="Inyecciones EJB">
    @EJB
    private DocenteFacadeLocal persistenciaDocente;
    @EJB
    private FacultadFacadeLocal persistenciaFacultad;
    @EJB
    private UsuarioFacadeLocal persistenciaUsuario;
    @EJB
    private DocenteFacadeLocal persistenciaDocenciaDirecta;
    @EJB
    private InvestigacionFacadeLocal persistenciaInvestigación;
    @EJB
    private MateriaFacadeLocal persistenciaMateria;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Publicacion getPublicacion() {
        if (publicacion == null) {
            publicacion = new Publicacion();
        }
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        if (!listPublicaciones.isEmpty()) {
            listPublicaciones.remove(publicacion);
        }
        this.publicacion = publicacion;
    }

    public List<Publicacion> getListPublicaciones() {
        if (listPublicaciones == null) {
            listPublicaciones = new ArrayList<>();
        }
        return listPublicaciones;
    }

    public void setListPublicaciones(List<Publicacion> listPublicaciones) {
        this.listPublicaciones = listPublicaciones;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Materia> getMaterias() {
        if (materias == null) {
            materias = persistenciaMateria.findMateriasActivas();
        }
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public ActExtAcademica getActExtAcademica() {
        if (actExtAcademica == null) {
            actExtAcademica = new ActExtAcademica();
        }
        return actExtAcademica;
    }

    public void setActExtAcademica(ActExtAcademica actExtAcademica) {
        if (!listActExtAcademicas.isEmpty()) {
            listActExtAcademicas.remove(actExtAcademica);
        }
        this.actExtAcademica = actExtAcademica;
    }

    public List<ActExtAcademica> getListActExtAcademicas() {
        if (listActExtAcademicas == null) {
            listActExtAcademicas = new ArrayList<>();
        }
        return listActExtAcademicas;
    }

    public void setListActExtAcademicas(List<ActExtAcademica> listActExtAcademicas) {
        this.listActExtAcademicas = listActExtAcademicas;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public List<Actividad> getActividades() {
        if (Actividades == null) {
            Actividades = new ArrayList<>();
        }
        return Actividades;
    }

    public void setActividades(List<Actividad> Actividades) {
        this.Actividades = Actividades;
    }

    public Investigacion getInvestigacion() {
        if (investigacion == null) {
            investigacion = new Investigacion();
        }
        return investigacion;
    }

    public void setInvestigacion(Investigacion investigacion) {
        if (!investigaciones.isEmpty()) {
            investigaciones.remove(investigacion);
        }
        this.investigacion = investigacion;
    }

    public List<Investigacion> getInvestigaciones() {
        if (investigaciones == null) {
            investigaciones = new ArrayList<>();
        }
        return investigaciones;
    }

    public void setInvestigaciones(List<Investigacion> investigaciones) {
        this.investigaciones = investigaciones;
    }

    public AsesoriaProyecto getAsesoriaProyecto() {
        if (asesoriaProyecto == null) {
            asesoriaProyecto = new AsesoriaProyecto();
        }
        return asesoriaProyecto;
    }

    public void setAsesoriaProyecto(AsesoriaProyecto asesoriaProyecto) {
        this.asesoriaProyecto = asesoriaProyecto;
    }

    public List<AsesoriaProyecto> getListAsesoriaProyectos() {
        if (listAsesoriaProyectos == null) {
            listAsesoriaProyectos = new ArrayList<>();
        }
        return listAsesoriaProyectos;
    }

    public void setListAsesoriaProyectos(List<AsesoriaProyecto> listAsesoriaProyectos) {
        this.listAsesoriaProyectos = listAsesoriaProyectos;
    }

    public ComisionEstudio getComisionEstudio() {
        if (comisionEstudio == null) {
            comisionEstudio = new ComisionEstudio();
        }
        return comisionEstudio;
    }

    public void setComisionEstudio(ComisionEstudio comisionEstudio) {
        if (!listComisionEstudios.isEmpty()) {
            listComisionEstudios.remove(comisionEstudio);
        }
        this.comisionEstudio = comisionEstudio;
    }

    public List<ComisionEstudio> getListComisionEstudios() {
        if (listComisionEstudios == null) {
            listComisionEstudios = new ArrayList<>();
        }
        return listComisionEstudios;
    }

    public void setListComisionEstudios(List<ComisionEstudio> listComisionEstudios) {
        this.listComisionEstudios = listComisionEstudios;
    }

    public Consejo getConsejo() {
        if (consejo == null) {
            consejo = new Consejo();
        }
        return consejo;
    }

    public void setConsejo(Consejo consejo) {
        if (!listConsejos.isEmpty()) {
            listConsejos.remove(consejo);
        }
        this.consejo = consejo;
    }

    public List<Consejo> getListConsejos() {
        if (listConsejos == null) {
            listConsejos = new ArrayList<>();
        }
        return listConsejos;
    }

    public void setListConsejos(List<Consejo> listConsejos) {
        this.listConsejos = listConsejos;
    }

    public DistribucionActividad getDistribucionActividad() {
        return distribucionActividad;
    }

    public void setDistribucionActividad(DistribucionActividad distribucionActividad) {
        this.distribucionActividad = distribucionActividad;
    }

    public List<DistribucionActividad> getListDistribucionActividades() {
        if (listDistribucionActividades == null) {
            listDistribucionActividades = new ArrayList<>();
        }
        return listDistribucionActividades;
    }

    public void setListDistribucionActividades(List<DistribucionActividad> listDistribucionActividades) {
        this.listDistribucionActividades = listDistribucionActividades;
    }

    public DocenciaDirecta getDocenciaDirecta() {
        if (docenciaDirecta == null) {
            docenciaDirecta = new DocenciaDirecta();
        }
        return docenciaDirecta;
    }

    public void setDocenciaDirecta(DocenciaDirecta docenciaDirecta) {
        if (!listDocenciaDirecta.isEmpty()) {
            listDocenciaDirecta.remove(docenciaDirecta);
        }
        this.docenciaDirecta = docenciaDirecta;
    }

    public List<DocenciaDirecta> getListDocenciaDirecta() {
        if (listDocenciaDirecta == null) {
            listDocenciaDirecta = new ArrayList<>();
        }
        return listDocenciaDirecta;
    }

    public void setListDocenciaDirecta(List<DocenciaDirecta> listDocenciaDirecta) {
        this.listDocenciaDirecta = listDocenciaDirecta;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Facultad> getFacultades() {
        if (facultades == null) {
            facultades = new ArrayList<>();
        }
        return facultades;
    }

    public void setFacultades(List<Facultad> facultades) {
        this.facultades = facultades;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Converter getFacultadConverter() {
        return facultadConverter;
    }

    public void setFacultadConverter(Converter facultadConverter) {
        this.facultadConverter = facultadConverter;
    }

    public boolean isMostar() {
        return mostar;
    }

    public void setMostar(boolean mostar) {
        this.mostar = mostar;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Converter getMateriaConverter() {
        if (this.materiaConverter == null) {
            this.materiaConverter = new Converter() {

                @Override
                public Object getAsObject(FacesContext context, UIComponent component, String value) {
                    Materia retorno = null;

                    if (value != null && !value.isEmpty()
                            && !value.trim().equals("[TODOS]")
                            && !value.trim().equals("[NINGUNO]")) {
                        BigDecimal materiaId = new BigDecimal(value);
                        for (Materia mate : getMaterias()) {
                            if (mate.getCodMateria().compareTo(materiaId) == 0) {
                                retorno = mate;
                                break;
                            }
                        }
                    }

                    return retorno;
                }

                @Override
                public String getAsString(FacesContext context, UIComponent component, Object value) {
                    String retorno = null;

                    if (value != null && value instanceof Materia) {
                        retorno = ((Materia) value).getCodMateria().toString();
                    }

                    return retorno;
                }
            };
        }
        return materiaConverter;
    }

    public void setMateriaConverter(Converter materiaConverter) {
        this.materiaConverter = materiaConverter;
    }
    //</editor-fold>

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            if (getListDocenciaDirecta().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Debe agregar al menos un curso de Docencia Directa.", ""));
                return event.getOldStep();
            }
            return event.getNewStep();
        }
    }

    public String agregarMateria() {
        try {
            if (docenciaDirecta.getCodMateria() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La asignatura es obligatoria.", ""));
                return null;
            }
            if (docenciaDirecta.getGrupo().equals("0")
                    || docenciaDirecta.getHorSemanal().compareTo(BigInteger.ZERO) == 0
                    || docenciaDirecta.getNmrEstudiantes().compareTo(BigInteger.ZERO) == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Debe ingresar valores en los campos diferentes a cero.", ""));
                return null;
            } else {
                getListDocenciaDirecta().add(docenciaDirecta);
                docenciaDirecta = new DocenciaDirecta();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso agregado.", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocurrio un Error agregando el Curso.", ""));
            e.printStackTrace();
        }
        return null;
    }

    public String agregarInvestigacion() {

        try {
            if (investigacion.getActDesarrollada().equals("")
                    || investigacion.getHorSemanal().compareTo(BigInteger.ZERO) == 0
                    || investigacion.getActProductos().equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Debe ingresar valores en los campos diferentes a cero.", ""));
                return null;
            } else {
                getInvestigaciones().add(investigacion);
                investigacion = new Investigacion();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Investigación agregada.", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocurrio un Error agregando la investigación.", ""));
            e.printStackTrace();
        }
        return null;
    }

    public String agregarExtension() {

        try {
            /*  if (actExtAcademica.getActDesarrollada().equals("")
             || actExtAcademica.getHorSemanal().compareTo(BigInteger.ZERO) == 0
             || actExtAcademica.getActProductos().equals("")) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Debe ingresar valores en los campos diferentes a cero.", ""));
             return null;
             } else {*/
            getListActExtAcademicas().add(actExtAcademica);
            actExtAcademica = new ActExtAcademica();
            /*actExtAcademica.setFec(null);
             actExtAcademica.setFecInicio(new Date());
             actExtAcademica.setNomActividad("NINGUNA");
             actExtAcademica.setHorDedicadas(new BigInteger("0"));*/
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad de Extensión Académica agregada.", ""));
            //}
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocurrio un Error agregando la actividad de Extensión Académica.", ""));
            e.printStackTrace();
        }
        return null;
    }
    
    public String agregarComision() {

        try {
            /*  if (actExtAcademica.getActDesarrollada().equals("")
             || actExtAcademica.getHorSemanal().compareTo(BigInteger.ZERO) == 0
             || actExtAcademica.getActProductos().equals("")) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Debe ingresar valores en los campos diferentes a cero.", ""));
             return null;
             } else {*/
            getListComisionEstudios().add(comisionEstudio);
            comisionEstudio = new ComisionEstudio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Comisión de estudio agregada.", ""));
            //}
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocurrio un Error agregando la Comisión de estudio.", ""));
            e.printStackTrace();
        }
        return null;
    }
    public String agregarPublicacon() {

        try {
            /*  if (actExtAcademica.getActDesarrollada().equals("")
             || actExtAcademica.getHorSemanal().compareTo(BigInteger.ZERO) == 0
             || actExtAcademica.getActProductos().equals("")) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Debe ingresar valores en los campos diferentes a cero.", ""));
             return null;
             } else {*/
            getListPublicaciones().add(publicacion);
            publicacion = new Publicacion();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Publicación agregada.", ""));
            //}
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocurrio un Error agregando la Publicación.", ""));
            e.printStackTrace();
        }
        return null;
    }
    
    public String agregarAsesorias() {

        try {
            /*  if (actExtAcademica.getActDesarrollada().equals("")
             || actExtAcademica.getHorSemanal().compareTo(BigInteger.ZERO) == 0
             || actExtAcademica.getActProductos().equals("")) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Debe ingresar valores en los campos diferentes a cero.", ""));
             return null;
             } else {*/
            getListAsesoriaProyectos().add(asesoriaProyecto);
            asesoriaProyecto = new AsesoriaProyecto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asesoría agregada.", ""));
            //}
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocurrio un Error agregando la Asesoría.", ""));
            e.printStackTrace();
        }
        return null;
    }

}
