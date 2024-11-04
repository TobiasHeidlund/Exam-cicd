import React from 'react'
import '/form.css'
import axios from 'axios';

function form(typeOfAction, setResult) {

    const [formData, setFormData] = useState({
        String: '',
        Seed: '',
        Encrypt: '',
      });
    const [submitted, setSubmitted] = useState(false);
    const apiUrl = import.meta.env.VITE_BACKENDURL;

    const onSubmit = (e)=>{
        e.preventDefault()
        console.log(formData)
        axios.post(apiUrl,formData).then((res)=>{
            if(res.status == 200){
                setSubmitted(true)
                e.currentTarget.reset()
                //DISPLAY HERE
                setFormData({...formData, String:'',Seed:''})
                setResult(res.data)
            }else{
                alert("Something went wrong please try again")
            }
        }).catch(error =>{
            console.log("Something went wrong")
            console.log(error)
        })

    }
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value // Update the specific field in state
        });
    };
  return 
  (
    <form onSubmit={onsubmit}>
        <input type="text" placeholder={'String to' + typeOfAction} name='String' onChange={handleChange}/>
        <input type="text" placeholder='Encryption Seed' name='Seed'  onChange={handleChange} />
        <input type="hidden" name="Encrypt" value={(typeOfAction=="Encrypt")}  onChange={handleChange} />
        <input type="submit" />
    </form>
  )
}


export default form