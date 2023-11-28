package seminar.three.lection.taskTwo.Model;

public enum ActionsType {

    Run,
    Swim,
    Jump;

    public static ActionsType getActionType(int typeId){

        return switch (typeId) {
            case 1 -> ActionsType.Run;
            case 2 -> ActionsType.Jump;
            case 3 -> ActionsType.Swim;
            default -> null;
        };
    }

}
