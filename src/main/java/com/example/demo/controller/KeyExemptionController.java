@PostMapping("/{apiKey}")
public ResponseEntity<String> add(@PathVariable String apiKey) {
    service.addExemption(apiKey);
    return ResponseEntity.ok("Exemption added");
}

@DeleteMapping("/{apiKey}")
public ResponseEntity<String> remove(@PathVariable String apiKey) {
    service.removeExemption(apiKey);
    return ResponseEntity.ok("Exemption removed");
}
