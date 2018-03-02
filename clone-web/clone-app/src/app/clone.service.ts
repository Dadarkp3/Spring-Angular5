import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { Clone } from '../clone';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class CloneService {
  private cloneUrl = 'http://localhost:8080/v1/clones';
  constructor(private http:HttpClient) {

   }

   public getAllClones() : Observable<any>{
    return this.http.get(this.cloneUrl+'/todos');
   }

   public adicionarClone(clone: Clone){
    return this.http.post(this.cloneUrl+'/adicionar', clone);
   }

   public deletarClone(clone: Clone){
    return this.http.delete(this.cloneUrl+'/deletar/' + clone.id);
   }

   public getCloneById(clone: Clone) : Observable<any>{
    return this.http.get(this.cloneUrl+'/clone/' + clone.id);
   }



}
