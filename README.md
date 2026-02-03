1. Klasa produkt (jakakolwiek klasa)

2. res -> layout -> new layout -> nazwa (widok na pojedyńczy element)

3. public class Klasa extends RecyclerView.Adapter<Klasa.InnaKlasaViewHolder>{} -> RPM (żarówka) -> Create Class

4. RPM (żarówka) na konstruktor -> Create constructor super

5. RPM (żarówka) na klase -> Implement method -> wszystkie 3 zaznaczone i "OK"


6. private LayoutInflater inflater; -> wstrzykiwanie widoku


7. public ZakupyAdapter(Context context, ArrayList<Produkt> produkty) {
        this.produkty = produkty;
        inflater = LayoutInflater.from(context); // Wygenerowanie konstruktora i inflatora

    }


8. public class ProduktViewHolder extends RecyclerView.ViewHolder{
        public CheckBox checkBoxView;
        public ZakupyAdapter zakupyAdapter; // final????


9. public ProduktViewHolder(@NonNull View itemView, ZakupyAdapter adapter) {
            super(itemView);
            checkBoxView = itemView.findViewById(R.id.checkBox);
            zakupyAdapter = adapter;
        }
    }


10. public ProduktViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.produkt_layout, parent, false);
        return new ProduktViewHolder(itemView, this);
    }


11. public void onBindViewHolder(@NonNull ProduktViewHolder holder, int position) {
        holder.checkBoxView.setText(produkty.get(position).toString());
    }


