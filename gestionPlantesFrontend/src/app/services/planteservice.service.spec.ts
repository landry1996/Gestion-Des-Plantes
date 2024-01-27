import { TestBed } from '@angular/core/testing';

import { PlanteserviceService } from './planteservice.service';

describe('PlanteserviceService', () => {
  let service: PlanteserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlanteserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
