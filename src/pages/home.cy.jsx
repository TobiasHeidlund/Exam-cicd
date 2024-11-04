import React from 'react'
import Home from './home'

describe('<home />', () => {
  it('renders', () => {
    // see: https://on.cypress.io/mounting-react
    cy.mount(<Home />)
  })
  beforeEach(()=>{
    cy.mount(<Home />)
  })
  describe('Verify Layout Encrypt', () => { 

    it("Encrypt Visable" , ()=>{
      cy.get(".encrypt").should("be.visible")
    })
    it("Encrypt Result Invisable" , ()=>{
      cy.get(".encrypt div").should("be.hidden")
    })
    it("Form Visable", ()=>{
      cy.get(".encrypt form").should("be.visible")
    })
  })
  describe('Verify Layout decrypt', () => { 
    it("Encrypt Visable" , ()=>{
      cy.get(".decrypt").should("be.visible")
    })
    it("Encrypt Result Invisable" , ()=>{
      cy.get(".decrypt div").should("be.hidden")
    })
    it("Form Visable", ()=>{
      cy.get(".decrypt form").should("be.visible")
    })
  })
})