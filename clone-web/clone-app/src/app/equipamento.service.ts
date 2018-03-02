import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { Equipamento } from '../equipamento';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class EquipamentoService {
  private equipUrl = 'http://localhost:8080/v1/equipamentos';
  constructor(private http:HttpClient) {

   }

   public getAllEquipamentos() : Observable<any>{
    return this.http.get(this.equipUrl+'/todos');
   }

   public getEquipamentoById(equipamento: Equipamento) : Observable<any>{
    return this.http.get(this.equipUrl+'/clone/' + equipamento.id);
   }

}
