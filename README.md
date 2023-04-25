
# Rapport

Uppgiften påbörjades genom att lägga till en `Activity` som kallas `SecondActivity`. Fortsättningsvis så lades views till `MainActivity` och `SecondActivity`. `MainActivity` innehåller en `Spinner` med tre olika alternativ som användaren kan välja mellan och en `Button`. För att kunna visa `SecondActivity` så implementerades en `onClickListener` ocn `onClick` metod för knappen i `MainActivity`. Knappen startar `SecondActivity` genom användning av intents. I kodstycket nedan visas metoden.

```java
Button showButton = findViewById(R.id.showButton);
showButton.setOnClickListener(new View.OnClickListener() {
    @Override    
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Spinner categorySpinner = findViewById(R.id.categorySpinner);
        String category = categorySpinner.getSelectedItem().toString();
        intent.putExtra("category", category); // Optional
        startActivity(intent);
    }
});
```

`SecondActivity` använder en `TextView` som presenterar den valda kategorin som valts i `Spinner` widgeten i `MainActivity`. Nedan visas ett stycke med den kod som används för att hantera datan som skickats med intents och för att bestämma texten för den nämnda `TextView` widget:en.

```java
String selectedCategory = "";
flipper = findViewById(R.id.flipper);

// handle bundled data
Bundle extras = getIntent().getExtras();
if (extras != null) {
    selectedCategory = extras.getString("category");
}

TextView header = findViewById(R.id.headerText);
header.setText(selectedCategory);
```

Fortsättningsvis så används även en `ViewFlipper` som bläddrar genom tre olika `TextView` widgets. Innehållet av dessa tre widgets baseras även på den valda kategorin i `MainActivity`. Alternativet sparas som en `String` och en selektion sker som kontrollerar vilken array som ska användas från resursfilen `strings.xml`. I xml-filen implementerades tre olika arrays som kan användas av `TextView` widgets:en. Varje array innehåller olika emojis som representerar en av de tre kategorier som kan väljas av användaren. I det kommande kodstycket så visas selektionen och hur respektive `TextView` tilldelas en emoji.

```java
// Select emojis based on the selected category
Resources resources = getResources();
String[] emojis = new String[flipper.getChildCount()];
if (selectedCategory.equals("Cats")) {
    emojis = resources.getStringArray(R.array.cats);
} else if (selectedCategory.equals("Dogs")) {
    emojis = resources.getStringArray(R.array.dogs);
} else if (selectedCategory.equals("Party")) {
    emojis = resources.getStringArray(R.array.party);
}

// get textViews from ViewFlipper and set emojis
TextView[] views = new TextView[flipper.getChildCount()];
for (int i = 0; i < flipper.getChildCount(); i++) {
    views[i] = (TextView) flipper.getChildAt(i);
    views[i].setText(emojis[i]);
}
```

Nedan visas bilder på hur `MainActivity` ser ut:

<img src="MainActivity-1.png" width="49%">
<img src="MainActivity-2.png" width="49%">

När en kategori är vald och användaren trycker på knappen så visas `SecondActivity` (se bild nedan).

<img src="SecondActivity.png" width="49%">
