package fitness_club.core.services;

//@Component
abstract public class ChangeClientFitnessCentreService {


   /* @Autowired
    private Database database;
    @Autowired
    private ChangeClientFitnessCentreValidator validator;

    public ChangeClientFitnessCentreResponse execute(ChangeClientFitnessCentreRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientFitnessCentreResponse(errors);
        }
        boolean isClientFitnessCentreChanged = database.isClientFitnessCentreChangedByPersonalCode(request.getPersonalCode(), request.getFitnessCentre());
        return new ChangeClientFitnessCentreResponse(isClientFitnessCentreChanged);
    }

    */
}
