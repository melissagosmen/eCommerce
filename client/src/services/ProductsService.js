export const getProducts = async (categoryId) => {
    const response = await fetch("http://localhost:8080/products/" + categoryId).then(res => res.json())
    console.log(response)
    return response;
}
