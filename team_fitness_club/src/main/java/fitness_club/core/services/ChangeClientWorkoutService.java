package fitness_club.core.services;

//@Component
public class ChangeClientWorkoutService {

   /* @Autowired
    private Database database;
    @Autowired
    private ChangeClientWorkoutsValidator validator;

    public ChangeClientWorkoutsResponse execute(ChangeClientWorkoutsRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientWorkoutsResponse(errors);
        }
        boolean isClientWorkoutChanged = database.clientWorkoutsChangedByPersonalCode(request.getPersonalCode(), request.getWorkout());
        return new ChangeClientWorkoutsResponse(isClientWorkoutChanged);
    }

    */
}
