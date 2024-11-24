package com.wora.citronix.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SuperficieDepasseeException.class)
    public ResponseEntity<Object> handleSuperficieDepasseeException(SuperficieDepasseeException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SuperficieMinimumException.class)
    public ResponseEntity<Object> handleSuperficieMinimumException(SuperficieMinimumException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Superficie50Exception.class)
    public ResponseEntity<Object> handleSuperficie50Exception(Superficie50Exception ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FermeDepasse10ChampsException.class)
    public ResponseEntity<Object> handleFermeDepasse10ChampsException(FermeDepasse10ChampsException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DatePlantationException.class)
    public ResponseEntity<Object> handleDatePlantationException(DatePlantationException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DensiteArbresException.class)
    public ResponseEntity<Object> handleDensiteArbresException(DensiteArbresException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PlusDe20Exception.class)
    public ResponseEntity<Object> handlePlusDe20Exception(PlusDe20Exception ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SaisonInvalidValueException.class)
    public ResponseEntity<String> handleInvalidEnumValue(SaisonInvalidValueException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecolteDoubleSaisonException.class)
    public ResponseEntity<String> handleRecolteDoubleSaison(RecolteDoubleSaisonException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}

