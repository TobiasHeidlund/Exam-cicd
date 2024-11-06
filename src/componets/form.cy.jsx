import React from 'react'
import Form from './form'

describe('<form />', () => {
  it('renders', () => {
    // see: https://on.cypress.io/mounting-react
    cy.mount(<Form />)
  })
  
  describe("Test Encryption",()=>{
    beforeEach(()=>{
      cy.mount(<Form typeOfAction={"Encrypt"}/>)
    })

    it("Can Se",()=>{
      cy.get("input[name=Seed]").should("be.visible")
      cy.get("textarea[name=String]").should("be.visible")
      cy.get("input[type=submit]").should("be.visible")
    })

    it("Can Type Seed",()=>{
      cy.get("input[name=Seed]").type("abc123").then(()=>{
        cy.get("input[name=Seed]").invoke("val").should("eq","abc123")
      })
    
    })

    it("Can Type String",()=>{
      cy.get("textarea[name=String]").type("abc124").then(()=>{
        cy.get("textarea[name=String]").invoke("val").should("eq","abc124")
      })
    
    })


  })


  


})